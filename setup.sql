--SQL SETUP
--Commands may need to be run separately depending on what version of SQL you have

--Create the user
CREATE USER cts@localhost IDENTIFIED BY "cts";

--Create the database
CREATE DATABASE CTS;

--Grant privileges
GRANT ALL ON cts.* TO cts@localhost;


