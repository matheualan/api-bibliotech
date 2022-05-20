CREATE TABLE tb_funcionarios (
    id_func BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL UNIQUE,
    cpf VARCHAR(14),
    PRIMARY KEY(id)
) engine=InnoDB default charset=utf8;

CREATE TABLE tb_clientes (
    id_cliente BIGINT NOT NULL IDENTITY(100, 1),
    nome VARCHAR(80) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    criadoEm DATETIME NOT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;