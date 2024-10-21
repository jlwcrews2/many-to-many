create table if not exists student(
    student_id bigint primary key,
    student_firstname varchar(50),
    student_lastname varchar(50),
    student_age int
);

create sequence student_seq;

create table if not exists student_course(
    student_id bigint not null,
    course_id bigint not null
);