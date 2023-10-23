# Sistema_Educativo
Es una actividad en clases, y esta es la base de Datos que realice en diagrams para esta actividad:

CREATE TABLE IF NOT EXISTS MATERIA (
    id SERIAL,
    MATERIA VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS DOCENTE (
    id SERIAL,
    DOCENTE VARCHAR(100) NOT NULL,
    table1_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (table1_id ) REFERENCES table1(id)
    );
