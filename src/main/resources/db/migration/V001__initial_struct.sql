create table if not exists teacher(
    teacher_id bigint primary key,
    teacher_firstname varchar(50),
    teacher_lastname varchar(50)
);

create sequence teacher_seq;

create table if not exists course(
    course_id bigint primary key,
    course_name varchar(100) not null,
    course_description varchar(200)
);

create sequence course_seq;