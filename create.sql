create table tb_receita
(
    id       integer generated always as identity
        constraint key_name
            primary key,
    user_id  integer not null
        constraint foreign_key_name
            references tb_user,
    titulo   varchar not null,
    conteudo varchar not null,
    foto     bytea
);
create table tb_user
(
    id    integer generated always as identity
        constraint id
            primary key,
    nome  varchar not null,
    email varchar not null
);
INSERT INTO tb_user(nome, email) VALUES ('Vânia Faleiro Cavalheiro', 'vania@email.com');
INSERT INTO tb_user(nome, email) VALUES ('Petra Cadaval Abasto', 'petra@email.com');
INSERT INTO tb_user(nome, email) VALUES ('Emilia Carvalhais Ferraz', 'emilia@email.com');
