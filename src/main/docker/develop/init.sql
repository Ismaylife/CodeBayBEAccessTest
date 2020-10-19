-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile
DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
         NAME VARCHAR(40),
         SURNAME VARCHAR(40),
         ACTIVE BOOLEAN,
         EMAIL VARCHAR(40) NOT NULL PRIMARY KEY,
         CITY VARCHAR(40),
         BIRTHDAY DATE,
         CREATIONDATE DATE);

     INSERT INTO USERS (NAME, SURNAME, ACTIVE, EMAIL, CITY, BIRTHDAY, CREATIONDATE)
     VALUES ('Ismael' , 'Ibanez' ,  TRUE,  'ismaeibanez6@gmail.com', 'Santa Cruz de Tenerife', TO_DATE('09/09/1996', 'DD/MM/YYYY'), TO_DATE('17/12/2015', 'DD/MM/YYYY') ),
     ('Pepe' , 'Perez' , FALSE,  'pepeperez@gmail.com', 'Praga', TO_DATE('08/01/1989', 'DD/MM/YYYY'), TO_DATE('10/10/2010', 'DD/MM/YYYY') ),
     ('Antonio' , 'Antunez' ,  TRUE,  'antonioantunez@gmail.com', 'Atlanta', TO_DATE('01/04/1966', 'DD/MM/YYYY'), TO_DATE('19/10/2011', 'DD/MM/YYYY') ),
     ('Ruben' , 'Rubiales' ,  FALSE,  'rubenrubiales@gmail.com', 'Roma', TO_DATE('13/11/1986', 'DD/MM/YYYY'), TO_DATE('13/11/2005', 'DD/MM/YYYY') );

     

    