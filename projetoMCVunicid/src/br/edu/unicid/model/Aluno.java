package br.edu.unicid.model;

public class Aluno {
	
	//atributos que serão salvos do aluno
	private String nome;
	private String RGM;
	private String nascimento;
	private String cpf;
	private String email;
	private String endereco;
	private String cell;
	private String uf;
	private String municipio;
	
	//informações do curso que o aluno será matriculado
	private String curso;
	private String campus;
	private String turno;
	
	//classes contrutoras

	public Aluno() {
	}
	
	public Aluno(String nome, String rgm, String nascimento, String cpf, 
			String email, String endereco, String cell,
			String uf, String municipio, String curso, String campus, 
			String turno) {
		this.nome = nome;
		this.RGM = rgm;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.cell = cell;
		this.uf = uf;
		this.municipio = municipio;
		this.curso = curso;
		this.campus = campus;
		this.turno = turno;
	}
	
	//Getters, Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRGM() {
		return RGM;
	}

	public void setRGM(String rGM) {
		RGM = rGM;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
}
