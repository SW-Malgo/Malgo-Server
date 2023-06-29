alter table keyword
    add column group_fk bigint;

alter table keyword
    add column member_fk bigint;

alter table keyword
    add constraint FKaj582caivpomwxs99g0yc5jxq
        foreign key (group_fk)
            references group_entity (group_id);

alter table keyword
    add constraint FK8nigcdj3apf5l90o4spdm6ml2
        foreign key (member_fk)
            references member (member_id);

