create table keyword_group (
       id bigint not null auto_increment,
        create_at datetime(6) not null,
        update_at datetime(6) not null,
        group_fk bigint,
        keyword_fk bigint,
        primary key (id)
);

alter table keyword_group
       add constraint FK7dw8jja84nj7aytmtwce1b75
       foreign key (group_fk)
       references group_entity (group_id);

alter table keyword_group
       add constraint FK7dw8jja84nj7aytmtwce1b76
       foreign key (keyword_fk)
       references keyword (keyword_id);