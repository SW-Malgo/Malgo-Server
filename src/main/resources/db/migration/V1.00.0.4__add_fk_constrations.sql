alter table group_entity
    add constraint FKpteg2v29ejys1quvneowbq2id
        foreign key (company_fk)
            references company (company_id);

alter table group_image
    add constraint FK9dxtgwa1y6c6j2lj0tm8kujbh
        foreign key (group_fk)
            references group_entity (group_id);

alter table group_members
    add constraint FK20ka6xg2w33v44ror55rg17k5
        foreign key (group_fk)
            references group_entity (group_id);

alter table group_members
    add constraint FK70ge3kbawflon3de8osrn33hj
        foreign key (company_fk)
            references member (member_id);

alter table group_post
    add constraint FKd2k0viln3eojxqrufo7tcbts1
        foreign key (group_id)
            references group_entity (group_id);

alter table post_image
    add constraint FKixu6t0ba6uofcau79jc2auo75
        foreign key (group_post_fk)
            references group_post (group_post_id);
