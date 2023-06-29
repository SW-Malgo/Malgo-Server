alter table company
    add column create_at datetime(6) not null;

alter table company
    add column update_at datetime(6) not null;

alter table group_entity
    add column create_at datetime(6);

alter table group_entity
    add column update_at datetime(6);

alter table group_entity
    add column company_fk bigint;

alter table group_image
    add column create_at datetime(6) not null;


alter table group_image
    add column update_at datetime(6) not null;


alter table group_image
    add column group_fk bigint;

alter table group_members
    add column create_at datetime(6);

alter table group_members
    add column update_at datetime(6);

alter table group_members
    add column group_fk bigint;

alter table group_members
    add column company_fk bigint;

alter table group_post
    add column create_at datetime(6);

alter table group_post
    add column update_at datetime(6);

alter table hit
    add column create_at datetime(6) not null;

alter table hit
    add column update_at datetime(6) not null;

alter table keyword
    add column create_at datetime(6) not null;

alter table keyword
    add column update_at datetime(6) not null;

alter table member
    add column create_at datetime(6) not null;


alter table member
    add column update_at datetime(6) not null;

alter table post_image
    add column create_at datetime(6) not null;

alter table post_image
    add column update_at datetime(6) not null;

alter table post_image
    add column group_post_fk bigint;
