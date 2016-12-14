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

import br.com.enumeration.Uf;

@Entity
@Table(name = "ENDERECO")
@JsonInclude(value = Include.NON_NULL)
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5169740573825191237L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENDERECO", nullable = false)
	private Integer id;

	@Column(name = "CEP", nullable = false)
	@NotEmpty
	@Length(min = 8, max = 8)
	private String cep;

	@Column(name = "DESCRICAO", nullable = false, length = 255)
	@NotEmpty
	@Length(min = 10, max = 255)
	private String descricao;

	@Column(name = "BAIRRO", nullable = false, length = 20)
	@NotEmpty
	@Length(min = 3, max = 20)
	private String bairro;

	@Column(name = "CIDADE", nullable = false, length = 30)
	@NotEmpty
	@Length(min = 3, max = 30)
	private String cidade;

	@Column(name = "COMPLEMENTO", nullable = false, length = 255)
	@Length(min = 0, max = 255)
	private String complemento;

	@Column(name = "UF", nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Uf uf;

	public Endereco() {
	}

	public Endereco(String cep, String descricao, String bairro, String cidade, String complemento, Uf uf) {
		setCep(cep);
		setDescricao(descricao);
		setBairro(bairro);
		setCidade(cidade);
		setComplemento(complemento);
		setUf(uf);
	}

	public Endereco(Integer id, String cep, String descricao, String bairro, String cidade, String complemento, Uf uf) {
		setId(id);
		setCep(cep);
		setDescricao(descricao);
		setBairro(bairro);
		setCidade(cidade);
		setComplemento(complemento);
		setUf(uf);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + getId() + ", cep=" + getCep() + ", descricao=" + getDescricao() + ", bairro="
				+ getBairro() + ", cidade=" + getCidade() + ", complemento=" + getComplemento() + ", uf=" + getUf()
				+ "]";
	}

}
