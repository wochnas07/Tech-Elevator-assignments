drop table if exists    employee        cascade;
drop table if exists    department      cascade;
drop table if exists    project         cascade;

create table employee
(
 employee_number        serial                  Not null
,job_title              character varying(50)   Not null
,last_name              character varying(50)   Not null
,first_name             character varying(50)   Not null
,gender                 character(1)            Not null
,date_of_birth          date                    
,date_of_hire           date                    
,employee_department    integer                 Not null
,constraint pk_employee_employee_number primary key(employee_number)
)
;

create table department
(
 department_number      serial                  Not null
,department_name        character varying(50)   Not null
,department_employees   integer
,constraint pk_department_department_number primary key(department_number)
)
;

create table project
(
 project_number         serial                  Not null
,project_name           character varying(50)   Not null
,project_start_date     date                    Not null
,project_employees      integer              
,project_department     integer                   
,constraint pk_project_project_number primary key(project_number)  
)
;

ALTER TABLE employee
        ADD FOREIGN KEY (employee_department)
        REFERENCES department(department_number)
;
ALTER TABLE project
        ADD FOREIGN KEY (project_department)
        REFERENCES department(department_number)
;

INSERT INTO department
(department_name)
VALUES('Sales')
;
INSERT INTO department
(department_name)
VALUES('Warehouse')
;
INSERT INTO department
(department_name)
VALUES('Management')
;

INSERT INTO employee
(job_title, last_name, first_name, gender, date_of_birth, employee_department)
VALUES('Sales', 'Halpert', 'Jim', 'M', '1979/10/01', 1)
;

INSERT INTO employee
(job_title, last_name, first_name, gender, date_of_birth, employee_department)
VALUES('Sales', 'Beasley', 'Pam', 'F', '1979/03/25', 1)
;

INSERT INTO employee
(job_title, last_name, first_name, gender, date_of_birth, employee_department)
VALUES('Sales', 'Schrute', 'Dwight', 'M', '1970/01/20', 1)
;

INSERT INTO employee
(job_title, last_name, first_name, gender, date_of_birth, employee_department)
VALUES('Sales', 'Hudson', 'Stanley', 'M', '1958/02/19', 1)
;

INSERT INTO employee
(job_title, last_name, first_name, gender, date_of_birth, employee_department)
VALUES('Warehouse', 'Philbin', 'Darryl', 'M', '1967/10/25', 2)
;

INSERT INTO employee
(job_title, last_name, first_name, gender, employee_department)
VALUES('Warehouse', 'Anderson', 'Roy', 'M', 2)
;

INSERT INTO employee
(job_title, last_name, first_name, gender, date_of_birth, employee_department)
VALUES('Management', 'Scott', 'Michael', 'M', '1965/03/15', 3)
;

INSERT INTO employee
(job_title, last_name, first_name, gender, employee_department)
VALUES('Management', 'Levinson', 'Jan', 'F', 3)
;


INSERT INTO project
(project_name, project_start_date)
VALUES ('Safety Training', '2007/04/12')
;

INSERT INTO project
(project_name, project_start_date)
VALUES ('Dinner Party', '2008/04/10')
;

INSERT INTO project
(project_name, project_start_date)
VALUES ('Basketball', '2005/04/19')
;

INSERT INTO project
(project_name, project_start_date)
VALUES ('CPR', '2009/02/01')
;