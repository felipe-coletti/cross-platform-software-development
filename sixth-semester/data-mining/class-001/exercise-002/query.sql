CREATE TABLE TAB1 AS SELECT e.last_name, d.department_name FROM employees e
JOIN departments d ON (e.department_ID=d.department_ID);

CREATE TABLE TAB2 AS SELECT d.department_name, l.city FROM employees e 
JOIN departments d ON e.department_id = d.department_id JOIN locations l ON 
d.location_id = l.location_id WHERE e.job_id = 'ST_CLERK'; 

CREATE TABLE TAB3 AS SELECT e.first_name, e.last_name FROM employees e 
JOIN departments d ON e.department_id = d.department_id JOIN locations l ON 
d.location_id = l.location_id WHERE l.city = 'Tokyo'; 

CREATE TABLE TAB4 AS SELECT DISTINCT l.city FROM departments d JOIN 
employees e ON d.department_id = e.department_id JOIN locations l ON 
d.location_id = l.location_id WHERE e.salary > 1500;
