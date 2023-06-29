create table group_entity (
        group_id bigint not null auto_increment,
        max_count bigint not null,
        name varchar(255),
        owner_id bigint,
        primary key (group_id)
);

create table group_members (
        group_member_id bigint not null auto_increment,
        group_id bigint,
        member_id bigint,
        primary key (group_member_id)
);

create table group_post (
        group_post_id bigint not null auto_increment,
        content varchar(255),
        group_id bigint,
        primary key (group_post_id)
);