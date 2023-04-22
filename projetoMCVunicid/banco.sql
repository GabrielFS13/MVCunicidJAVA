CREATE DATABASE IF NOT EXISTS javaMVCunicid2000;

CREATE TABLE IF NOT EXISTS tb_aluno(
	rgm VARCHAR(30) PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    nascimento VARCHAR(10) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    uf VARCHAR(2) NOT NULL,
    municipio VARCHAR(20),
    celular VARCHAR(16),
    endereco VARCHAR(50),
	curso VARCHAR(60) NOT NULL,
    campus VARCHAR(20) NOT NULL,
    turno VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_notas(
	rgm VARCHAR(30),
    nota FLOAT,
    matéria VARCHAR(40),
    semestre VARCHAR(20),
    faltas TINYINT,
    FOREIGN KEY (rgm) REFERENCES tb_aluno(rgm)
);

INSERT INTO tb_aluno(rgm, nome, email, nascimento, cpf, uf, municipio, celular, endereco, curso, campus, turno) 
VALUES 
('29951241', 'Gabriel Falcão', 'gabriel.falcao.carvalho2020@gmail.com', '2004/06/09','478.070.158-89','SP', 'São Paulo', '(11) 9-873657416', 'R Manoel da luz drummond', 'Ciência da Computação', 'Tatuapé', 'Noturno');
INSERT INTO tb_notas(rgm, nota, matéria, semestre, faltas) VALUES ('29951241', 10, 'Programação Orientada a Objeto', '1-2023', 0);


UPDATE tb_aluno SET nome = 'Jorge', email = 'gabriel@falcao.com', nascimento = '2020/04/02', cpf = '3849129392', uf = 'AC', municipio = 'Acre', 
celular = '11971087064', endereco = 'Rua dos bobos', curso = 'Odontologia', campus = 'Pinheiros', turno = 'Vesperino' WHERE rgm = '29951241';
UPDATE tb_notas SET nota = '3', matéria = 'Saude Bocal', semestre = '1-2020', faltas = '6' WHERE rgm = '29951241' and matéria = 'Saude Bocal';

DELETE FROM tb_notas WHERE rgm = '29951241';
DELETE FROM tb_aluno WHERE rgm = '29951241';