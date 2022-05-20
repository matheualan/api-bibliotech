CREATE TABLE tb_livros (
    idLivro BIGINT NOT NULL IDENTITY(100, 1),
    titulo VARCHAR(40) NOT NULL,
    autor VARCHAR(20) NOT NULL,
    paginas BIGINT,
    PRIMARY KEY(idLivro)
) engine=InnoDB default charset=utf8;