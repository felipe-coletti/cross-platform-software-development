conn system/manager

CREATE OR REPLACE DIRECTORY PHOTO_UPLOAD as 'C:\images';
GRANT READ ON DIRECTORY PHOTO_UPLOAD TO HR;

conn hr/hr

CREATE TABLE images (
    id NUMBER(2),
    description VARCHAR2(30),
    photos BLOB
);

DECLARE
    L_BLOB BLOB;
    L_BFILE BFILE;
BEGIN
    INSERT INTO images (ID, DESCRIPTION, PHOTOS)
    VALUES (17, 'Uma imagem de perfil', EMPTY_BLOB())
    RETURNING PHOTOS INTO L_BLOB;

    L_BFILE := BFILENAME('PHOTO_UPLOAD', 'image.png');

    DBMS_LOB.FILEOPEN(L_BFILE);
    DBMS_LOB.LOADFROMFILE(L_BLOB, L_BFILE, DBMS_LOB.GETLENGTH(L_BFILE));
    DBMS_LOB.FILECLOSE(L_BFILE);
    COMMIT;
END;
/

SELECT * FROM images
