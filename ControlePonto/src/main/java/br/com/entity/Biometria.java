package br.com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "BIOMETRIA")
@JsonInclude(value = Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Biometria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6840041778706352543L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BIOMETRIA", nullable = false)
	private Integer id;

	@Column(name = "NUMERO", nullable = false)
	@NotNull
	private Long numero;

	@OneToOne(mappedBy = "biometria", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private Pessoa pessoa;

	@OneToMany(mappedBy = "biometria", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private List<Controle> controle;

	public Biometria() {
		setControle(new ArrayList<Controle>());
	}

	public Biometria(Long numero, Pessoa pessoa, List<Controle> controle) {
		setNumero(numero);
		setPessoa(pessoa);
		setControle(controle);
	}

	public Biometria(Integer id, Long numero, Pessoa pessoa, List<Controle> controle) {
		setId(id);
		setNumero(numero);
		setPessoa(pessoa);
		setControle(controle);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Controle> getControle() {
		return controle;
	}

	public void setControle(List<Controle> controle) {
		this.controle = controle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Biometria other = (Biometria) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Biometria [id=" + getId() + ", numero=" + getNumero() + ", pessoa=" + getPessoa() + ", controle="
				+ getControle() + "]";
	}

}
