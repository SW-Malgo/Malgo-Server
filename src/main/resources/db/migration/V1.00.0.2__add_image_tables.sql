create table group_image
(
    post_image_id bigint       not null auto_increment,
    source        varchar(255) not null,
    thumbnail     bit          not null,
    primary key (post_image_id)
);


create table post_image
(
    post_image_id bigint       not null auto_increment,
    source        varchar(255) not null,
    primary key (post_image_id)
)
