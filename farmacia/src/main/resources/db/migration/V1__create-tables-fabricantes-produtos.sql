CREATE TABLE fabricantes (
    id int NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
    nome varchar(255) unique,
    PRIMARY KEY (id)
);

CREATE TABLE produtos (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    preco FLOAT,
    descricao VARCHAR(100),
    fabricante_id int,
    FOREIGN KEY (fabricante_id) REFERENCES fabricantes (id)
);