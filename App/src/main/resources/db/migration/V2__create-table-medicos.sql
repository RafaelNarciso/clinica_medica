CREATE TABLE medicos (

                         id VARCHAR(36) NOT NULL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         crm VARCHAR(50) NOT NULL UNIQUE,
                         especialidade VARCHAR(100) NOT NULL,
                         telefone_id VARCHAR(36),
                         logradouro VARCHAR(100),
                         bairro VARCHAR(100),
                         cep VARCHAR(9),
                         cidade VARCHAR(100),
                         uf CHAR(2),
                         numero VARCHAR(20),
                         complemento VARCHAR(100),
                         FOREIGN KEY (telefone_id) REFERENCES telefones(id)
);