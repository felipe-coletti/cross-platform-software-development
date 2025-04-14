CREATE TABLE raw_sales_data (
  gender_cio VARCHAR2(20),
  segment_cliente VARCHAR2(50),
  country_cliente VARCHAR2(100),
  country_code VARCHAR2(5),
  product VARCHAR2(50),
  units_vendidas VARCHAR2(20),
  gross_value VARCHAR2(20),
  discounts VARCHAR2(20),
  net_value VARCHAR2(20),
  purchase_date VARCHAR2(20),
  sale_date VARCHAR2(20)
) ORGANIZATION EXTERNAL (
  TYPE ORACLE_LOADER
  DEFAULT DIRECTORY FAM_DIR
  ACCESS PARAMETERS (
    RECORDS DELIMITED BY NEWLINE
    FIELDS TERMINATED BY ','
  )
  LOCATION ('car_data_font.txt')
);

CREATE TABLE sales_data (
  gender_cio VARCHAR2(20),
  segment VARCHAR2(50),
  country VARCHAR2(100),
  country_code VARCHAR2(5),
  product VARCHAR2(50),
  units NUMBER,
  gross_value NUMBER,
  discounts NUMBER,
  net_value NUMBER,
  purchase_date DATE,
  sale_date DATE,
  negotiation_time NUMBER GENERATED ALWAYS AS (sale_date - purchase_date) VIRTUAL,
  country_segment VARCHAR2(60) GENERATED ALWAYS AS (segment || ' - ' || country_code) VIRTUAL
);

INSERT INTO sales_data (
  gender_cio, segment, country, country_code, product, units,
  gross_value, discounts, net_value,
  purchase_date, sale_date
)
SELECT
  CASE 
 WHEN LOWER(TRIM(gender_cio)) IN ('m', 'masc', 'masculino', 'homem') THEN 'Masculino'
 WHEN LOWER(TRIM(gender_cio)) IN ('f', 'fem', 'feminino', 'mulher') THEN 'Feminino'
 ELSE 'Outro'
  END,
  segment_cliente,
  country_cliente,
  country_code,
  product,
  TO_NUMBER(units_vendidas),
  TO_NUMBER(gross_value),
  TO_NUMBER(discounts),
  TO_NUMBER(net_value),
  TO_DATE(purchase_date, 'DD/MM/YYYY'),
  TO_DATE(sale_date, 'DD/MM/YYYY')
FROM raw_sales_data;

SELECT product, negotiation_time FROM sales_data;

SELECT DISTINCT country_segment FROM sales_data;

SELECT product, net_value FROM sales_data;

SELECT 
  segment,
  gender_cio,
  ROUND(COUNT(*) * 100 / SUM(COUNT(*)) OVER (PARTITION BY segment), 2) AS percentual
FROM sales_data
GROUP BY segment, gender_cio;

SELECT
  ROUND(COUNT(DISTINCT country_code) * 100.0 / (SELECT COUNT(DISTINCT country_code) FROM raw_sales_data), 2) AS percentual_countryes_que_compraram
FROM sales_data;

SELECT 
  product, 
  ROUND(AVG(net_value), 2) AS media_net_value
FROM sales_data
GROUP BY product;

SELECT 
  country_code, 
  ROUND(AVG(net_value), 2) AS media_net_value
FROM sales_data
GROUP BY country_code;
