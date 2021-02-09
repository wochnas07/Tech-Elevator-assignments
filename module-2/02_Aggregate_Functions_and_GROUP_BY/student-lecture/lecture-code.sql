--------------------------------------------------------------------------------------------------------
-- Ordering, Grouping Basic Functions Lecture Code
--------------------------------------------------------------------------------------------------------
--
-- ORDER BY -  Sequence of Rows in Result
--
--    ORDER BY          -- Ascending Sequence (low-high)
--    ORDER BY ASC      -- Ascending Sequence (low-high)
--    ORDER BY DESC     -- Descending Sequence (high-low)

-- There is no guarantee of the order of the rows in the sesult without an ORDER BY clause
--      You can run the same query 100 times without an ORDER BY and get the same result
--      The 101 time might be a different result order

-- IF THE ORDER OF THE ROWS IN THE RESULT MATTER, CODE AN ORDER BY

-- In standard SQL, the ORDER BY is always last in the queery,
--      (postgresSQL) unless there is a LIMIT

-- Show Populations of all countries in acscending order
SELECT  name, population
FROM    country
ORDER BY population
;

-- Show Populations of all countries in descending order
select  name, population
from    country
order by continent, population desc
;


-- Show  the names of countries and continents in ascending order
select  name, population
from    country
order by continent, name
;
--------------------------------------------------------------------------------------------------------
-- Limiting the number of rows in the result
--
-- LIMIT n   - Limit the number of rows in the result - always goes at thE end of the SELECT
--
-- LIMIT is postgresSQL extenstion to standard SQL
-- other data base managers limit rows, but call it something other than LIMIST
--      also have you code it somewhere else
--
--
-- Show the name and life expectancy of the countries with the 10 highest life expectancies.
SELECT  name, lifeexpectancy
FROM    country
WHERE   lifeexpectancy IS NOT null
ORDER BY lifeexpectancy desc -- show the life expectancy from highest to lowest
LIMIT   10      -- only return the first 10 rows in the result
;

--------------------------------------------------------------------------------------------------------
-- Concatenating values 
--
-- the concat operator (||) may be used to concatenate character (string) values in a result
--

-- Show the name & state in the format: "city-name, state"
-- of all cities in California, Oregon, or Washington.
-- sorted by state then city
SELECT  name || ', ' || district AS city_state
FROM    city
WHERE   district = 'California'
OR      district = 'Oregon'
OR      district = 'Washington'
;

--------------------------------------------------------------------------------------------------------
-- Aggregate functions - produce one row in result for each group specified
--                       rather than one row in the result for each row that matches the WHERE clause
--
-- The group used by the aggregate functions is determined by the GROUP BY clause
-- if no GROUP BY clause is specified, the group is the set of rows in the result
--
--     AVG(column-expression)   - arithmentic average for group of non-NULL values in expression 
--     SUM(column-expression)   - arithmentic sum for group of a non-NULL values in expression 
--     MIN(column-expression)   - lowest value for group of non-NULL values in expression 
--     MAX(column-expression)   - highest value for group of non-NULL values in expression 
--     COUNT(*)                 - number of rows in the group
--     COUNT(column-expression) - number of rows for the group of non-NULL values in expression 
--
--
-- AVG(), SUM() may only bes used with numeric data types
-- MIN(), MAX() may be used with numeric, character, date, time datatypes
--
-- COUNT() is applied to rows (not columns)
--
--
-- Show average life expectancy in the world
SELECT  AVG(lifeexpectancy)     -- one row in the result with the average life expectancy across all countries
FROM    country
;

-- Show average life expectancy for each continent
SELECT  continent, AVG(lifeexpectancy) AS Avg_Life_Expectancy    
FROM    country
GROUP BY continent              -- specify the groups we want for the aggregate function
;
-- Show the total population in Ohio
SELECT  SUM(population) AS Total_People_In_Ohio
FROM    city
WHERE   district = 'Ohio'
;

-- Show the surface area of the smallest country in the world
SELECT  name, surfacearea
FROM    country
ORDER BY surfacearea
LIMIT   1
;

-- Show The 10 largest countries (by surface area) in the world
SELECT  name, surfacearea
FROM    country
ORDER BY surfacearea desc
LIMIT   10
;

-- Show the number of countries who declared independence in 1991
SELECT  COUNT(*)
FROM    country
WHERE   indepyear = 1991
;

--------------------------------------------------------------------------------------------------------
-- GROUP BY  - Specify the group to which the aggregate functions apply
--
--      GROUP BY column-expression
--
-- When using a GROUP BY the SELECT is limited ot aggreggate functions or columns in the GROUP BY
--
--

-- Show the number of countries where each language is spoken, order show them from most countries to least
SELECT  COUNT(*)
FROM    countrylanguage
GROUP BY language
ORDER BY 1 desc
;

-- Show the average life expectancy of each continent ordered from highest to lowest
SELECT  continent, AVG(lifeexpectancy)
FROM    country
GROUP BY continent
ORDER BY 2 desc
;


-- Exclude Antarctica from consideration for average life expectancy
SELECT  continent, AVG(lifeexpectancy)
FROM    country
WHERE   lifeexpectancy IS NOT null
GROUP BY continent
ORDER BY 2 desc
;


-- What is the sum of the population of cities in each state in the USA ordered by state name
SELECT  district, SUM(population) as population
FROM    city
WHERE   countrycode = 'USA'
GROUP BY district
ORDER BY district
;


-- What is the average population of cities in each state in the USA ordered by state name
SELECT  distrcit, AVG(population) as population
FROM    city
WHERE   countrycode = 'USA'
GROUP BY district
ORDER BY district
;

--------------------------------------------------------------------------------------------------------
-- SUBQUERIES - Using the result from one query (inner query) in another query (outer query)
--
-- Frequently used in a WHERE clause with an IN predicate:
--
--       WHERE column-name IN (SELECT column-name FROM some-table WHERE some-predicate)
--
-- Any WHERE predicate may be used to connect the subquery in a WHERE clause, but you must
-- be sure a single value is returned from the subquery. 
--
-- Subqueries may also be used in a SELECT as a column-specification or a FROM as a table
-- (These are advanced concepts we will discuss later, if there is time)
--
-- Show the cities under the same given government leader


-- Show countries with the same independece year


-- Show the cities cities whose country has not yet declared independence yet


--------------------------------------------------------------------------------------------------------
--
-- Additional samples
--
-- You may alias column and table names to provide more descriptive names
--
SELECT name AS CityName 
  FROM city AS cities

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name
     , population 
  FROM city 
 WHERE countryCode='USA' 
 ORDER BY name ASC, population DESC
;
-- Limiting results allows rows to be returned in 'limited' clusters where LIMIT says how many, 
-- and an optional OFFSET specifies number of rows to skip
SELECT name
     , population 
  FROM city 
  LIMIT 10 OFFSET 10
;