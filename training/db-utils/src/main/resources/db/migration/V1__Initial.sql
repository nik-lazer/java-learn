create table Language (
	uid BINARY(16),
	name varchar (50)
);
insert into Language (uid, name) values (UUID(), 'English');
insert into Language (uid, name) values (UUID(), 'French');