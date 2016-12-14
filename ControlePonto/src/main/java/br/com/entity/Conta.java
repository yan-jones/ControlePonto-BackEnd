package br.com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.enumeration.TipoConta;

@Entity
@Table(name = "CONTA")
@JsonInclude(value = Include.NON_NULL)
public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8994470523547569660L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTA", nullable = false)
	private Integer id;

	@Column(name = "NUMERO", nullable = false, length = 10)
	@NotEmpty
	@Length(min = 4, max = 10)
	private String numero;

	@Column(name = "AGENCIA", nullable = false, length = 8)
	@NotEmpty
	@Length(min = 4, max = 8)
	private String agencia;

	@Column(name = "TIPO_CONTA", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoConta tipoConta;

	public Conta() {
	}

	public Conta(String numero, String agencia, TipoConta tipoConta) {
		setNumero(numero);
		setAgencia(agencia);
		setTipoConta(tipoConta);
	}

	public Conta(Integer id, String numero, String agencia, TipoConta tipoConta) {
		setId(id);
		setNumero(numero);
		setAgencia(agencia);
		setTipoConta(tipoConta);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conta [id=" + getId() + ", numero=" + getNumero() + ", agencia=" + getAgencia() + ", tipoConta="
				+ getTipoConta() + "]";
	}

}
