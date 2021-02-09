--------------------------------------------------------------------------------------------------------
-- Basic SELECT Lecture Code
--------------------------------------------------------------------------------------------------------
-- -- indicates a comment - anything following on the line is ignored
--
-- SQL SELECT statement - retrieve values form the database (Read)
--
-- A SELECT statement is often referred to as a query
--
-- Basic syntax: (the order in which these are is important/required)
--
--      SELECT   - columns to include in the result (seperate mutiple column reqeusts with commas)
--      FROM     - table containing rows used in the query 
--      WHERE    - rows to include in the result        - WHERE predicates are similar to Java predicates (a predicate is a condition)
--      ORDER BY - sequence of rows in the result
--                 without an ORDER BY the sequence of the rows in the result is not predictable
--                 if the sequence of teh rows in teh result matter - code an ORDER BY
--
-- WHERE predicates:
--
--        =  <>  !=  >  >=  <  <= 
--        IN(list-of-values)      -- alterative to a series of = OR
--        NOT IN(list-of-values)  -- alterative to a series of != AND
--        BETWEEN value AND value
--        IS NULL
--        IS NOT NULL
--        LIKE    (use wildcards: % means 0 to any number of any characters
--                                _ means exactly any one character
--                      "word%'         - starts with test
--                      '%word'         - ends with test
--                      '%word%'        - contains test
--        ILIKE   (case insensivtive LIKE - Postgres extension)
--
-- predicates may be combined using AND and OR
--
-- use parentheses to make your multi-predicate condition clear

-- The DISTINCT clause on a SELECT removes duplicate values from the result
-- based on the all columns that follow
--
-- The DISTINCT ON(columns/expression) clause on a SELECT removes duplicate values from the result
-- based on the all columns/expression inside the parentheses that follow (Postgres extension)
------------------------------------------------------------------------------------------------------

-- Selecting the names for all countries
Select  name                    -- list the column(s) you want to see in the result on the SELECT
from    country                 -- specify the table with the column(s) you want on the FROM
;                               -- ; marks the end of SQL statement

-- Selecting the name and population of all countries
SELECT name, population         -- list the column(s) you want to see in the result
FROM country                    -- speicfy the table with the columns on the from
;
SELECT  population, name
FROM    country
;
-- Selecting all columns from the city table
select  *                        -- * - List all the columns in the table in the order in which they are defined
from    country
;

-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
select  name, district
from    city
where district = 'Ohio'         -- in SQL you put single quotes around strings. not double quotes as in Java
;                               -- the case of the literal matters: 'Ohio' is different than "OHIO" - know your database

-- Selecting countries that gained independence in the year 1776
select name, indepyear
from country
where indepyear = 1776          -- numeric values are NOT coded in single quotes
;

-- Selecting countries not in Asia
select name, continent
from country
where continent != 'Asia'
;

-- Selecting countries that do not have an independence year
select name, indepyear
from country
where indepyear IS null         -- null represents an unknown or missing value so = and != doesnt work
;

-- Selecting countries that do have an independence year
select name, indepyear
from country
where indepyear IS NOT null
;

-- Selecting countries that have a population greater than 5 million
select name, population
from country
where population > 5000000
;

-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
select name, district, population
from city
where district = 'Ohio'
and population > 400000
;

-- Selecting country names on the continent North America or South America
select name, continent
from country
where continent = 'North America'       -- where continent IN('North America', 'South America') IN can replace a series of =/or
or continent = 'South America'
;
select name, continent
from country
where continent LIKE '%America%'
;

-- List the countries that gained independence in the 20th Century (1900-1999)
select name, indepyear
from coutnry
where indepyear >= 1900
and indepyear <= 1999
;

select name, indepyear
from coutnry
where indepyear BETWEEN 1900 AND 1999   -- BETWEEN wil select data in an inclusive range


-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
select name, population, lifeexpectancy, population / surfacearea
from country
;

select name, population, lifeexpectancy, population / surfacearea as pop_per_area
from country
;
