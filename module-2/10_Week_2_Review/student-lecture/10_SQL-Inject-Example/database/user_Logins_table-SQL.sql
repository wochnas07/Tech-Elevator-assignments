--
-- The SQL Injection Sample program expects these table to be in a database called "users"
--
--   createdb -U postgres userlogin
--
-- if you run this in another database be sure to change the SQL Injection Sample
-- program datasource to the right database
--
--
begin transaction;

drop table if exists user_logins;

Create table user_logins
(userid char(20)
,password char(20)
);

insert into user_logins 
values('franko','javania');

insert into user_logins 
values('Vinny','mycousin');

insert into user_logins
values('Vito','godfather');

commit;