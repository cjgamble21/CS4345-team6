# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  password                      varchar(255),
  title                         varchar(255),
  firstname                     varchar(255),
  lastname                      varchar(255),
  email                         varchar(255),
  phone                         varchar(255),
  fax                           varchar(255),
  address                       varchar(255),
  city                          varchar(255),
  state                         varchar(255),
  zip                           integer,
  research_areas                varchar(255),
  position                      varchar(255),
  affiliation                   varchar(255),
  status                        varchar(255),
  degree_plan                   varchar(255),
  degree_begin                  varchar(255),
  grad_date                     varchar(255),
  comments                      varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists user;

