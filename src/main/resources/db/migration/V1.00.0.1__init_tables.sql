create table company (
    company_id bigint not null auto_increment,
    code varchar(255) not null,
    name varchar(255) not null,
    primary key (company_id)
) engine=InnoDB;

create table keyword (
    keyword_id bigint not null auto_increment,
    tag varchar(255) not null,
    primary key (keyword_id)
) engine=InnoDB;

create table member (
    member_id bigint not null auto_increment,
    certification_id varchar(255) not null,
    keyword varchar(255) not null,
    password varchar(255) not null,
    company_company_id bigint not null,
    primary key (member_id)
) engine=InnoDB;

create table hit (
    hit_id bigint not null auto_increment,
    count integer not null,
    keyword_keyword_id bigint not null,
    primary key (hit_id)
) engine=InnoDB;

alter table hit
    add constraint hit_keyword_fk
        foreign key (keyword_keyword_id)
            references keyword (keyword_id);

alter table member
    add constraint member_company_fk
        foreign key (company_company_id)
            references company (company_id)