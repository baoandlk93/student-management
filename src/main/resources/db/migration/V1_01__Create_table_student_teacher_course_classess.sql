create table student
(
    id         binary(16)   not null
        primary key,
    address    varchar(255) null,
    email      varchar(255) not null unique,
    name       varchar(255) null,
    phone      varchar(255) not null unique,
    classes_id binary(16)   null
);

create table teacher
(
    id      binary(16)   not null
        primary key,
    address varchar(255) null,
    classes varchar(255) null,
    email   varchar(255) null,
    name    varchar(255) null,
    phone   varchar(255) null
);
create table course
(
    id          binary(16)   not null
        primary key,
    credit      int          null,
    description varchar(255) null,
    name        varchar(255) null,
    classes_id  binary(16)   null
);

create table classes
(
    id          binary(16)   not null
        primary key,
    description varchar(255) null,
    name        varchar(255) null
);

alter table student
    add constraint FKstudentclassess
        foreign key (classes_id) references classes (id);
alter table course
    add constraint FKcourseclassess
        foreign key (classes_id) references classes (id);
create table course_student
(
    course_id  binary(16) not null,
    student_id binary(16) not null,
    primary key (course_id, student_id),
    constraint FK6course_student
        foreign key (course_id) references course (id),
    constraint FK6studentcourse
        foreign key (student_id) references student (id)
);
create table course_teacher
(
    course_id  binary(16) not null,
    teacher_id binary(16) not null,
    primary key (course_id, teacher_id),
    constraint FK6course_teacher
        foreign key (course_id) references course (id),
    constraint FK6teachercourse
        foreign key (teacher_id) references teacher (id)
);


