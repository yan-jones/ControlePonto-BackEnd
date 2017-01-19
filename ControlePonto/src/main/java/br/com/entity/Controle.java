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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "CONTROLE")
@JsonInclude(value = Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Controle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4495729957173638156L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTROLE", nullable = false)
	private Integer id;

	@Column(name = "DATA_ENTRADA", nullable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",
	// timezone = "GMT-3")
	@NotNull
	private Timestamp dataEntrada;

	@Column(name = "DATA_SAIDA", nullable = true)
	// @Temporal(TemporalType.TIMESTAMP)
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",
	// timezone = "GMT-3")
	private Timestamp dataSaida;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_BIOMETRIA", nullable = false)
	@NotNull
	private Biometria biometria;

	public Controle() {
	}

	public Controle(Timestamp dataEntrada, Biometria biometria) {
		setDataEntrada(dataEntrada);
		setBiometria(biometria);
	}

	public Controle(Timestamp dataEntrada, Timestamp dataSaida, Biometria biometria) {
		setDataEntrada(dataEntrada);
		setDataSaida(dataSaida);
		setBiometria(biometria);
	}

	public Controle(Integer id, Timestamp dataEntrada, Timestamp dataSaida, Long numero, String nome) {
		setId(id);
		setDataEntrada(dataEntrada);
		setDataSaida(dataSaida);
		setBiometria(new Biometria(numero, nome));
	}

	public Controle(Integer id, Timestamp dataEntrada, Timestamp dataSaida, Biometria biometria) {
		setId(id);
		setDataEntrada(dataEntrada);
		setDataSaida(dataSaida);
		setBiometria(biometria);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Timestamp getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Timestamp dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Biometria getBiometria() {
		return biometria;
	}

	public void setBiometria(Biometria biometria) {
		this.biometria = biometria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((biometria == null) ? 0 : biometria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Controle other = (Controle) obj;
		if (biometria == null) {
			if (other.biometria != null)
				return false;
		} else if (!biometria.equals(other.biometria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Controle [id=" + getId() + ", dataEntrada=" + getDataEntrada() + ", dataSaida=" + getDataSaida()
				+ ", biometria=" + getBiometria() + "]";
	}

}
