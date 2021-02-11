

-- Subquery Example --------------------------------------------------------------------------------------------
-- 
--Show the country name, city name, district
--
-- we need data from more than one table - country table and city table
--
-- whenever you need data from more than one table - code a join
--
-- A join matches rows between tables based on a join condition
--
-- join condition defines how rows between tables should be matched
--
-- if names between are duplicated you must make uniques using tablename.column-name
--
-- Two formats for coding a join:
--
--      1. Classic Syntax       - code all the tables on the from and the join condition on the WHERE clause
--      2. Modern Syntax        - code the type of join between the table names and the join condition in ON clause
--
------------------------------------------------------------------------------------------------------------------
-- Classic Syntax Join
------------------------------------------------------------------------------------------------------------------
SELECT  country.name, city.name, district       -- columns you want in the result
FROM    country, city                           -- tables(s) with the columns you want
-- we need to match the data between city and country by countrycode
WHERE   country.code = city.countrycode
AND     country.code = 'USA'
;
------------------------------------------------------------------------------------------------------------------
-- Modern Syntax Join
------------------------------------------------------------------------------------------------------------------
SELECT  country.name, city.name, district
FROM    country                                 -- code one of the tables in the join
        inner join                              -- type join - inner join shows matches between tables based on join conidtion
        city                                    -- code the other table in the join
ON      country.code = city.countrycode         -- join condistion - we want the rows that match between city and country tables by country code
WHERE   country.code = 'USA'                    -- filtering conditions in the WHERE as usual
;
------------------------------------------------------------------------------------------------------------------

-- list of the names of the countries that speak English
--
-- The country language table has the country codes that speak each language
--
--      1. Get a list of country codes that speak English from the countrylanguage table
--      2. Get the name of the country from the country table if the code in the country table is in the list from #1
--
--  A subquery is where the result of one select is used in another select
-- Used when data from one table is needed to search another table or data from one table is needed in another
--
-- a subquery may only return one column (a list)
--
-- Usually link the queries with an IN due to a list being returned from the subquery
--
-- The subquery is run first and the list returned from it is plugged into the IN clause of the outer SELECT
--
-- You can nest up to generally 32,765 subqueries (more than you'll ever need)
--
-- we needed the countrycodes from countrylanguage that spoke English to search country table for the names of those countries
--
SELECT  name
FROM    country
WHERE   code in ( select        countrycode                     -- list of countrycodes
                        FROM    countrylanguage                 -- from the countrylanguage table
                        WHERE   language = 'English'            -- where the language is English
;