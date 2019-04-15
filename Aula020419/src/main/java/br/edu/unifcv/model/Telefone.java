package br.edu.unifcv.model;

public class Telefone extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long professor_id;
	private Long aluno_;
	
	
	public Long getAluno_() {
		return aluno_;
	}

	public void setAluno_(Long aluno_) {
		this.aluno_ = aluno_;
	}

	private String contato;
	private String telefone;

	public Long getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(Long professor_id) {
		this.professor_id = professor_id;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
