alter table conta drop foreign key FK5A7376FC9A4E8E6
alter table pedido drop foreign key FKC4DD1745BA27DDDA
alter table pedido drop foreign key FKC4DD174565269BEE
alter table pedido_produtos drop foreign key FK9E498854CC1722AE
alter table pedido_produtos drop foreign key FK9E498854AA65ED86
alter table produto drop foreign key FKED8DCEF9E28508BF
drop table if exists conta
drop table if exists mesa
drop table if exists pedido
drop table if exists pedido_produtos
drop table if exists produto
drop table if exists tipo_produto
drop table if exists usuario
create table conta (id bigint not null auto_increment, dataAbertura datetime not null, dataFechamento datetime, mesa_id bigint not null, primary key (id))
create table mesa (id bigint not null, primary key (id))
create table pedido (id bigint not null auto_increment, data datetime not null, observacoes text, conta_id bigint not null, usuario_login varchar(255) not null, primary key (id))
create table pedido_produtos (pedido_id bigint not null, qtd_produtos integer not null, produto_id bigint, primary key (pedido_id, produto_id))
create table produto (id bigint not null auto_increment, descricao varchar(255) not null, preco numeric(19,2), tipo_id bigint not null, primary key (id))
create table tipo_produto (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id))
create table usuario (DTYPE varchar(31) not null, login varchar(255) not null, senha varchar(255), nome varchar(255), primary key (login))
alter table conta add index FK5A7376FC9A4E8E6 (mesa_id), add constraint FK5A7376FC9A4E8E6 foreign key (mesa_id) references mesa (id)
alter table pedido add index FKC4DD1745BA27DDDA (usuario_login), add constraint FKC4DD1745BA27DDDA foreign key (usuario_login) references usuario (login)
alter table pedido add index FKC4DD174565269BEE (conta_id), add constraint FKC4DD174565269BEE foreign key (conta_id) references conta (id)
alter table pedido_produtos add index FK9E498854CC1722AE (produto_id), add constraint FK9E498854CC1722AE foreign key (produto_id) references produto (id)
alter table pedido_produtos add index FK9E498854AA65ED86 (pedido_id), add constraint FK9E498854AA65ED86 foreign key (pedido_id) references pedido (id)
alter table produto add index FKED8DCEF9E28508BF (tipo_id), add constraint FKED8DCEF9E28508BF foreign key (tipo_id) references tipo_produto (id)
