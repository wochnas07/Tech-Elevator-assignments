-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
BEGIN TRANSACTION;
        INSERT INTO actor
        (actor_id, first_name, last_name)
        VALUES (201, 'HAMPTON', 'AVENUE')
;
        INSERT INTO actor
        (actor_id, first_name, last_name)
        VALUES (202, 'LISA', 'BYWAY')
        ;
SELECT * FROM actor WHERE actor_id > 200;
-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
        INSERT INTO film
        (film_id, title, description, release_year, language_id, length)
        VALUES (1001, 'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198)
        ;
-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
        INSERT INTO film_actor
        (film_id, actor_id)
        VALUES (1001, 201)
        ;
        INSERT INTO film_actor
        (film_id, actor_id)
        VALUES (1001, 202)
        ;
-- 4. Add Mathmagical to the category table.
        INSERT INTO category
        (category_id, name)
        VALUES (17, 'Mathemagical')
        ;
-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
        INSERT INTO film_category
        (film_id, category_id)
        VALUES (1001, 17)
        ;
        INSERT INTO film_category
        (film_id, category_id)
        VALUES (274, 17)
        ;
        INSERT INTO film_category
        (film_id, category_id)
        VALUES (494, 17)
        ;
        INSERT INTO film_category
        (film_id, category_id)
        VALUES (714, 17)
        ;
        INSERT INTO film_category
        (film_id, category_id)
        VALUES (996, 17)
        ;        
-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
        UPDATE film
        SET rating = 'G'
        WHERE film_id IN
                (SELECT film_id FROM film_category WHERE category_id = 
                (SELECT category_id FROM category WHERE name = 'Mathemagical'))
        ;
-- 7. Add a copy of "Euclidean PI" to all the stores.
        INSERT INTO inventory
        (film_id, store_id)
        VALUES ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), 1)
        ;
        INSERT INTO inventory
        (film_id, store_id)
        VALUES ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), 2)   
        ;     
-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
        DELETE FROM film
                WHERE title = 'Euclidean PI'
        ;

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
        DELETE FROM category
                WHERE category = 'Mathemagical'
        ;
-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
        DELETE FROM film_category
                WHERE category_id = 18
        ;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>
        DELETE FROM category
                WHERE category = 'Mathemagical'
        ;
        DELETE FROM film
                WHERE title = 'Euclidean PI'
        ;        

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
ROLLBACK;