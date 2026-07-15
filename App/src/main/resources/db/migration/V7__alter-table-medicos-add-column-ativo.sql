ALTER TABLE medicos
    ADD ativo TINYINT(1) NOT NULL DEFAULT 1;

UPDATE medicos
SET ativo = 1;V7__alter-table-medicos-add-column-ativo.sql