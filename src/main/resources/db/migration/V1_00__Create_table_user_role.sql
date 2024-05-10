create table user
(
    id        binary(16)          not null
        primary key,
    email     varchar(255) unique not null,
    full_name varchar(255)        null,
    password  varchar(255)        null,
    username  varchar(255) unique not null
);

create table role
(
    id          binary(16)   not null
        primary key,
    description varchar(255) null,
    name        varchar(255) null
);



create table user_role
(
    user_id binary(16) not null,
    role_id binary(16) not null,
    primary key (user_id, role_id),
    constraint FK859n2jvi8ivhui0rl0esws6o
        foreign key (user_id) references user (id),
    constraint FKa68196081fvovjhkek5m97n3y
        foreign key (role_id) references role (id)
);
insert into role(id, name, description)
values (unhex(replace(uuid(), '-', '')), 'ROLE_STUDENT', 'Student role'),
       (unhex(replace(uuid(), '-', '')), 'ROLE_ADMIN', 'Admin role'),
       (unhex(replace(uuid(), '-', '')), 'ROLE_TEACHER', 'Teacher role');
# insert into user(id, username, password, full_name, email)
# values (unhex(replace(uuid(), '-', '')),
#         'anhaadmin',
# #         password: 123
#         '$2a$10$UGrF57qf6kVknQz4.S2XUudhYezm4mdSGhYZ.HNgUSe//KEcegxHm',
#         'admin', 'b1p6y@example.com');
#
# insert into user_role(user_id, role_id)
# values ((select id from user where username = 'anhaadmin'), (select id from role where name = 'ROLE_ADMIN'));

