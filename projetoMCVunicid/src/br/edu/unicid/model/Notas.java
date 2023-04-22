package br.edu.unicid.model;

public class Notas{
	
	private String RGM;
	private String materia;
	private String semestre;
	private int faltas;
	private float nota;

	
	public Notas() {
	}

	public Notas(String rgm, String materia, String semestre, int faltas, float nota) {
		this.RGM = rgm;
		this.materia = materia;
		this.semestre = semestre;
		this.faltas = faltas;
		this.nota = nota;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getRGM() {
		return RGM;
	}

	public void setRGM(String rgm) {
		this.RGM = rgm;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	
}
