package br.com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "VINCULACAO")
@JsonInclude(value = Include.NON_NULL)
public class Vinculacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1462853651009330160L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VINCULACAO", nullable = false)
	private Integer id;

	@Column(name = "DATA_INICIO", nullable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",
	// timezone = "GMT-3")
	@NotNull
	private Timestamp dataInicio;

	@Column(name = "DATA_FINAL", nullable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",
	// timezone = "GMT-3")
	@NotNull
	@Past
	private Timestamp dataFinal;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PESSOA", nullable = false)
	@NotNull
	private Pessoa pessoa;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_EQUIPAMENTO", nullable = false)
	@NotNull
	private Equipamento equipamento;

	public Vinculacao() {
	}

	public Vinculacao(Timestamp dataInicio, Timestamp dataFinal, Pessoa pessoa, Equipamento equipamento) {
		setDataInicio(dataInicio);
		setDataFinal(dataFinal);
		setPessoa(pessoa);
		setEquipamento(equipamento);
	}

	public Vinculacao(Integer id, Timestamp dataInicio, Timestamp dataFinal, Pessoa pessoa, Equipamento equipamento) {
		setId(id);
		setDataInicio(dataInicio);
		setDataFinal(dataFinal);
		setPessoa(pessoa);
		setEquipamento(equipamento);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Timestamp dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Timestamp getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Timestamp dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFinal == null) ? 0 : dataFinal.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((equipamento == null) ? 0 : equipamento.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Vinculacao other = (Vinculacao) obj;
		if (dataFinal == null) {
			if (other.dataFinal != null)
				return false;
		} else if (!dataFinal.equals(other.dataFinal))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (equipamento == null) {
			if (other.equipamento != null)
				return false;
		} else if (!equipamento.equals(other.equipamento))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vinculacao [id=" + getId() + ", dataInicio=" + getDataInicio() + ", dataFinal=" + getDataFinal()
				+ ", pessoa=" + getPessoa() + ", equipamento=" + getEquipamento() + "]";
	}

}
