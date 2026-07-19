create table if not exists example
(
  id   int,
  name varchar(255)
);

truncate table example;
insert into example (id, name)
values ('1', 'Alice');
insert into example (id, name)
values ('2', 'Bob');
