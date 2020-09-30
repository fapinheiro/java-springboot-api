insert into roles (role_id, description) values (1, 'ROLE_ADMIN');
insert into roles (role_id, description) values (2, 'ROLE_USER');
insert into roles (role_id, description) values (3, 'ROLE_CLIENT');
insert into roles (role_id, description) values (4, 'ROLE_PARTNER');

insert into addresses (address_id, street_name, street_complement, creation_at)
values (seq_addresses.nextval, 'av. bulhao pato', 'n44 3esq', current_date);

insert into clients (client_id, email, password, name, birth_date, creation_at, updated_at, active, address_id)
values (seq_clients.nextval, 'filipe@gmail.com', '$2a$10$wB0XIhjN9IvPh9cNWNHSHeGv67rbLizId7Lz4lcSjzIJoOQgjnC4a', 'Filipe Pinheiro', current_date, current_date, null, 1, 1);
insert into clients (client_id, email, password, name, birth_date, creation_at, updated_at, active, address_id)
values (seq_clients.nextval, 'ines@gmail.com', '$2a$10$wB0XIhjN9IvPh9cNWNHSHeGv67rbLizId7Lz4lcSjzIJoOQgjnC4a', 'Inês Quelhas', current_date, current_date, null, 1, 1);
insert into clients (client_id, email, password, name, birth_date, creation_at, updated_at, active, address_id)
values (seq_clients.nextval, 'barbara@gmail.com', '$2a$10$wB0XIhjN9IvPh9cNWNHSHeGv67rbLizId7Lz4lcSjzIJoOQgjnC4a', 'Barbara Consan', current_date, current_date, null, 1, 1);
insert into clients (client_id, email, password, name, birth_date, creation_at, updated_at, active, address_id)
values (seq_clients.nextval, 'sarah@gmail.com', '$2a$10$wB0XIhjN9IvPh9cNWNHSHeGv67rbLizId7Lz4lcSjzIJoOQgjnC4a', 'Sarah Pinheiro', current_date, current_date, null, 0, 1);