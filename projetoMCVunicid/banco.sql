CREATE DATABASE IF NOT EXISTS grupolambda;

CREATE TABLE IF NOT EXISTS tb_aluno(
	rgm VARCHAR(10) PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    nascimento DATE NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    uf VARCHAR(2) NOT NULL,
    municipio VARCHAR(20) NOT NULL,
    celular VARCHAR(16) UNIQUE NOT NULL,
    endereco VARCHAR(50) NOT NULL,
	curso VARCHAR(60) NOT NULL,
    campus VARCHAR(20) NOT NULL,
    turno VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_notas(
	rgm VARCHAR(10) NOT NULL,
    nota FLOAT NOT NULL,
    matéria VARCHAR(40) NOT NULL,
    semestre VARCHAR(20) NOT NULL,
    faltas SMALLINT NOT NULL,
    FOREIGN KEY (rgm) REFERENCES tb_aluno(rgm)
);

DELETE FROM tb_notas WHERE rgm = '29951241';
DELETE FROM tb_aluno WHERE rgm = '29951241';