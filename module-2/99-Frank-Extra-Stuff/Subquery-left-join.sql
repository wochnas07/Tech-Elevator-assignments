--
-- Show any actors we have in the actor table who are not in any films
-- in the film table (ie. no entry in the film_actor table)

--
-- 1. Add some test data to the actor table we know are do not
--    have matches in the film table;

Begin transaction;
insert into actor (first_name, last_name) values('Vinny', 'Ricky');
insert into actor (first_name, last_name) values('Billy', 'Shanygne');
insert into actor (first_name, last_name) values('Jake', 'David');
insert into actor (first_name, last_name) values('Dan', 'Michael');
insert into actor (first_name, last_name) values('Chris', 'Jason');
insert into actor (first_name, last_name) values('Gabe', 'Michael');
insert into actor (first_name, last_name) values('Seth', 'Kyle');
insert into actor (first_name, last_name) values('Kurt', 'George');
insert into actor (first_name, last_name) values('Rez', 'Spencer');
insert into actor (first_name, last_name) values('Frank', 'Patrick');

--
--  2a. Problem solved with sub-query
--

select actor_id, count(*)
from actor
where actor_id not in (Select actor_id from film_actor) 
group by actor_id
;

--
-- Problem solved with left-join actor table to file_actor table
--

select a.actor_id, a.first_name, a.last_name
from actor a
left join
film_actor fa
on a.actor_id = fa.actor_id
where fa.actor_id is null
;
--
-- 3. Reset table to original state before test data inserted
--
rollback;