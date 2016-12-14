package br.com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.enumeration.Perfil;
import br.com.enumeration.Sexo;
import br.com.enumeration.Status;
import br.com.enumeration.Titulacao;

@Entity
@Table(name = "FUNCIONARIO")
@PrimaryKeyJoinColumns({ @PrimaryKeyJoinColumn(name = "ID_PESSOA") })
@JsonInclude(value = Include.NON_NULL)
public class Funcionario extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4498696281900968319L;

	@Column(name = "DATA_ADMISSAO", nullable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",
	// timezone = "GMT-3")
	@NotNull
	@Past
	private Timestamp dataAdmissao;

	@Column(name = "TITULACAO", nullable = true)
	@Enumerated(EnumType.STRING)
	private Titulacao titulacao;

	public Funcionario() {
	}

	public Funcionario(String nome, String senha, String cpf, String rg, String email, Timestamp dataNascimento,
			Sexo sexo, Perfil perfil, Status status, Endereco endereco, Conta conta, Biometria biometria,
			Timestamp dataAdmissao, Titulacao titulacao) {
		super(nome, senha, cpf, rg, email, dataNascimento, sexo, perfil, status, endereco, conta, biometria);
		setDataAdmissao(dataAdmissao);
		setTitulacao(titulacao);
	}

	public Funcionario(Integer id, String nome, String senha, String cpf, String rg, String email,
			Timestamp dataNascimento, Sexo sexo, Perfil perfil, Status status, Endereco endereco, Conta conta,
			Biometria biometria, Timestamp dataAdmissao, Titulacao titulacao) {
		super(id, nome, senha, cpf, rg, email, dataNascimento, sexo, perfil, status, endereco, conta, biometria);
		setDataAdmissao(dataAdmissao);
		setTitulacao(titulacao);
	}

	public Timestamp getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Timestamp dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Titulacao getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(Titulacao titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + ((titulacao == null) ? 0 : titulacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		Funcionario other = (Funcionario) obj;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (titulacao != other.titulacao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [dataAdmissao=" + getDataAdmissao() + ", titulacao=" + getTitulacao() + ", pessoa="
				+ super.toString() + "]";
	}

}
