CREATE TABLE consultas (
                           id VARCHAR(36) NOT NULL,
                           medico_id VARCHAR(36) NOT NULL,
                           paciente_id VARCHAR(36) NOT NULL,
                           data DATETIME NOT NULL,

                           PRIMARY KEY (id),

                           CONSTRAINT fk_consultas_medico
                               FOREIGN KEY (medico_id)
                                   REFERENCES medicos(id),

                           CONSTRAINT fk_consultas_paciente
                               FOREIGN KEY (paciente_id)
                                   REFERENCES pacientes(id)
);