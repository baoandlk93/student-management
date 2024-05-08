create table user
(
    id        binary(16)   not null
        primary key,
    email     varchar(255) null,
    full_name varchar(255) null,
    password  varchar(255) null,
    username  varchar(255) null
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

