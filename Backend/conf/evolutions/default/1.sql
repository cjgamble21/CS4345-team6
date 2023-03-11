# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table course (
  id                            bigint auto_increment not null,
  user_id                       bigint,
  name                          varchar(255),
  constraint pk_course primary key (id)
);

create table taapplication (
  id                            bigint auto_increment not null,
  firstname                     varchar(255),
  lastname                      varchar(255),
  email                         varchar(255),
  phone                         varchar(255),
  degree_plan                   varchar(255),
  degree_begin                  varchar(255),
  grad_date                     varchar(255),
  first_preference              varchar(255),
  second_preference             varchar(255),
  third_preference              varchar(255),
  non_preference                varchar(255),
  constraint pk_taapplication primary key (id)
);

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

alter table course add constraint fk_course_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_course_user_id on course (user_id);


# --- !Downs

alter table course drop foreign key fk_course_user_id;
drop index ix_course_user_id on course;

drop table if exists course;

drop table if exists taapplication;

drop table if exists user;

