package br.com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.enumeration.Perfil;
import br.com.enumeration.Sexo;
import br.com.enumeration.Status;
import br.com.enumeration.Titulacao;

@Entity
@Table(name = "ALUNO")
@PrimaryKeyJoinColumns({ @PrimaryKeyJoinColumn(name = "ID_PESSOA") })
@JsonInclude(value = Include.NON_NULL)
public class Aluno extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7822848511725731256L;

	@Column(name = "NRO_KIT", nullable = true)
	@Min(value = 1)
	private Integer nroKit;

	@Column(name = "TURMA", nullable = true, length = 10)
	@Length(min = 0, max = 10)
	private String turma;

	public Aluno() {
	}

	public Aluno(String nome, String senha, String cpf, String rg, String email, Timestamp dataNascimento, Sexo sexo,
			Perfil perfil, Status status, Endereco endereco, Conta conta, Biometria biometria, Timestamp dataAdmissao,
			Titulacao titulacao, Integer nroKit, String turma) {
		super(nome, senha, cpf, rg, email, dataNascimento, sexo, perfil, status, endereco, conta, biometria);
		setNroKit(nroKit);
		setTurma(turma);
	}

	public Aluno(Integer id, String nome, String senha, String cpf, String rg, String email, Timestamp dataNascimento,
			Sexo sexo, Perfil perfil, Status status, Endereco endereco, Conta conta, Biometria biometria,
			Timestamp dataAdmissao, Titulacao titulacao, Integer nroKit, String turma) {
		super(id, nome, senha, cpf, rg, email, dataNascimento, sexo, perfil, status, endereco, conta, biometria);
		setNroKit(nroKit);
		setTurma(turma);
	}

	public Integer getNroKit() {
		return nroKit;
	}

	public void setNroKit(Integer nroKit) {
		this.nroKit = nroKit;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nroKit == null) ? 0 : nroKit.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		Aluno other = (Aluno) obj;
		if (nroKit == null) {
			if (other.nroKit != null)
				return false;
		} else if (!nroKit.equals(other.nroKit))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [nroKit=" + getNroKit() + ", turma=" + getTurma() + ", pessoa=" + super.toString() + "]";
	}

}
