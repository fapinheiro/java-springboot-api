insert into roles (role_id, description) values (1, 'ROLE_ADMIN');
insert into roles (role_id, description) values (2, 'ROLE_USER');
insert into roles (role_id, description) values (3, 'ROLE_CLIENT');
insert into roles (role_id, description) values (4, 'ROLE_PARTNER');

insert into clients (client_id, email, password, name, birth_date, creation_at, updated_at, active)
values (seq_clients.nextval, 'filipe@gmail.com', '1234', 'Filipe Pinheiro', current_date, current_date, null, 1);
insert into clients (client_id, email, password, name, birth_date, creation_at, updated_at, active)
values (seq_clients.nextval, 'ines@gmail.com', '1234', 'Inês Quelhas', current_date, current_date, null, 1);
insert into clients (client_id, email, password, name, birth_date, creation_at, updated_at, active)
values (seq_clients.nextval, 'barbara@gmail.com', '1234', 'Barbara Consan', current_date, current_date, null, 1);
insert into clients (client_id, email, password, name, birth_date, creation_at, updated_at, active)
values (seq_clients.nextval, 'sarah@gmail.com', '1234', 'Sarah Pinheiro', current_date, current_date, null, 0);