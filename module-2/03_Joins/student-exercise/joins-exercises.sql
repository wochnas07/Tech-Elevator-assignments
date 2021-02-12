-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT  title
FROM    actor
        INNER JOIN
        film_actor
ON      actor.actor_id = film_actor.actor_id
        INNER JOIN
        film
ON      film.film_id = film_actor.film_id
WHERE   first_name = 'NICK'
AND     last_name = 'STALLONE'
;

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT  title
FROM    actor
        INNER JOIN
        film_actor
ON      actor.actor_id = film_actor.actor_id
        INNER JOIN
        film
ON      film.film_id = film_actor.film_id
WHERE   first_name = 'RITA'
AND     last_name = 'REYNOLDS'
;

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT  title
FROM    actor
        INNER JOIN
        film_actor
ON      actor.actor_id = film_actor.actor_id
        INNER JOIN
        film
ON      film.film_id = film_actor.film_id
WHERE   first_name = 'RIVER'
AND     last_name = 'DEAN'
OR      first_name = 'JUDY'
AND     last_name = 'DEAN'
;

-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT  title
FROM    category
        INNER JOIN
        film_category
ON      category.category_id = film_category.category_id
        INNER JOIN
        film
ON      film.film_id = film_category.film_id
WHERE   name = 'Documentary'
;
-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT  title
FROM    category
        INNER JOIN
        film_category
ON      category.category_id = film_category.category_id
        INNER JOIN
        film
ON      film.film_id = film_category.film_id
WHERE   name = 'Comedy'
;

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT  title
FROM    category
        INNER JOIN
        film_category
ON      category.category_id = film_category.category_id
        INNER JOIN
        film
ON      film.film_id = film_category.film_id
WHERE   name = 'Children'
AND     film.rating = 'G'
;
        
-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
SELECT  title
FROM    category
        INNER JOIN
        film_category
ON      category.category_id = film_category.category_id
        INNER JOIN
        film
ON      film.film_id = film_category.film_id
WHERE   name = 'Family'
AND     film.rating = 'G'
AND     film.length < 120
;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT  title
FROM    actor
        INNER JOIN
        film_actor
ON      actor.actor_id = film_actor.actor_id
        INNER JOIN
        film
ON      film.film_id = film_actor.film_id
WHERE   first_name = 'MATTHEW'
AND     last_name = 'LEIGH'
AND     film.rating = 'G'
;

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT  title
FROM    category
        INNER JOIN
        film_category
ON      category.category_id = film_category.category_id
        INNER JOIN
        film
ON      film.film_id = film_category.film_id
WHERE   name = 'Sci-Fi'
AND     film.release_year = 2006
;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT  title
FROM    film
        INNER JOIN
        film_category
ON      film.film_id = film_category.film_id
        INNER JOIN
        category
ON      category.category_id = film_category.category_id
        INNER JOIN
        film_actor
ON      film.film_id = film_actor.film_id
        INNER JOIN
        actor
ON      film_actor.actor_id = actor.actor_id
WHERE   category.name = 'Action' 
AND     actor.first_name = 'NICK'
AND     actor.last_name = 'STALLONE'
;

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT  store, address, city, district, country
FROM    country
        INNER JOIN
        city
ON      country.country_id = city.country_id
        INNER JOIN
        address
ON      city.city_id = address.city_id
        INNER JOIN
        store
ON      address.address_id = store.store_id
;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT  store.store_id, address.address, first_name, last_name
FROM    store
        INNER JOIN
        address
ON      store.address_id = address.address_id
        INNER JOIN
        staff
ON      store.manager_staff_id = staff.staff_id
ORDER BY store.store_id
;


-- 13. The first and last name of the top ten customers ranked by number of rentals
-- (#1 should be “ELEANOR HUNT�? with 46 rentals, #10 should have 39 rentals)
SELECT  first_name, last_name, COUNT(*)
FROM    rental
        INNER JOIN
        customer
ON      rental.customer_id = customer.customer_id
GROUP BY customer.customer_id
ORDER BY count desc
LIMIT   10
;

-- 14. The first and last name of the top ten customers ranked by dollars spent
-- (#1 should be “KARL SEAL�? with 221.55 spent, #10 should be “ANA BRADLEY�? with 174.66 spent)
SELECT  first_name, last_name, SUM(amount)
FROM    payment
        INNER JOIN
        customer
ON      payment.customer_id = customer.customer_id
GROUP BY customer.customer_id
ORDER BY SUM(amount) desc
LIMIT   10
;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that while a customer has only one primary store, they may rent from either store.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT  store.store_id, address.address, count(*), SUM(payment.amount), AVG(payment.amount)
FROM    store
        INNER JOIN
        address
ON      store.address_id = address.address_id
        INNER JOIN
        inventory
ON      store.store_id = inventory.inventory_id
        INNER JOIN
        rental
ON      inventory.inventory_id = rental.inventory_id
        INNER JOIN
        payment
ON      rental.rental_id = payment.rental_id
GROUP BY store.store_id, address.address_id
;

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD�? with 34 rentals and #10 should have 31 rentals)
SELECT  title, COUNT(rental_id)
FROM    rental
        INNER JOIN
        inventory
ON      rental.inventory_id = inventory.inventory_id
        INNER JOIN
        film
ON      inventory.film_id = film.film_id
GROUP BY film.title
ORDER BY COUNT desc
LIMIT 10
;

-- 17. The top five film categories by number of rentals
-- (#1 should be “Sports�? with 1179 rentals and #5 should be “Family�? with 1096 rentals)
SELECT  category, COUNT(rental_id)
FROM    rental
        INNER JOIN
        inventory
ON      rental.inventory_id = inventory.inventory_id
        INNER JOIN
        film
ON      inventory.film_id = film.film_id
        INNER JOIN
        film_category
ON      film.film_id = film_category.film_id
        INNER JOIN
        category
ON      film_category.category_id = category.category_id
GROUP BY category
ORDER BY COUNT desc
LIMIT 5
;

-- 18. The top five Action film titles by number of rentals
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT  title, COUNT(rental_id)
FROM    rental
        INNER JOIN
        inventory
ON      rental.inventory_id = inventory.inventory_id
        INNER JOIN
        film
ON      inventory.film_id = film.film_id
        INNER JOIN
        film_category
ON      film.film_id = film_category.film_id
        INNER JOIN
        category
ON      film_category.category_id = category.category_id
WHERE   name = 'Action'
GROUP BY title
ORDER BY COUNT desc
LIMIT 5
;

-- 19. The top 10 actors ranked by number of rentals of films starring that actor
-- (#1 should be “GINA DEGENERES�? with 753 rentals and #10 should be “SEAN GUINESS�? with 599 rentals)
SELECT  first_name, last_name, COUNT(rental_id)
FROM    rental
        INNER JOIN
        inventory
ON      rental.inventory_id = inventory.inventory_id
        INNER JOIN
        film
ON      inventory.film_id = film.film_id
        INNER JOIN
        film_actor
ON      film.film_id = film_actor.film_id
        INNER JOIN
        actor
ON      film_actor.actor_id = actor.actor_id
GROUP BY actor.actor_id
ORDER BY COUNT desc
LIMIT 10
;


-- 20. The top 5 “Comedy�? actors ranked by number of rentals of films in the “Comedy�? category starring that actor
-- (#1 should have 87 rentals and #5 should have 72 rentals)
SELECT  first_name, last_name, COUNT(*)
FROM    rental
        INNER JOIN
        inventory
ON      rental.inventory_id = inventory.inventory_id
        INNER JOIN
        film
ON      inventory.film_id = film.film_id
        INNER JOIN
        film_actor
ON      film.film_id = film_actor.film_id
        INNER JOIN
        actor
ON      film_actor.actor_id = actor.actor_id
        INNER JOIN
        film_category
ON      film.film_id = film_category.film_id
        INNER JOIN
        category
ON      film_category.category_id = category.category_id
WHERE   name = 'Comedy'
GROUP BY actor.actor_id
ORDER BY COUNT desc
LIMIT 5
;