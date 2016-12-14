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

import br.com.enumeration.TipoEquipamento;

@Entity
@Table(name = "EQUIPAMENTO")
// @NamedQueries({ @NamedQuery(name = "RelatorioEquipamentos", query = "from
// Equipamento e order by e.tipo") })
@JsonInclude(value = Include.NON_NULL)
public class Equipamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6411856739733925690L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EQUIPAMENTO", nullable = false)
	private Integer id;

	@Column(name = "NRO_SERIE", nullable = false, length = 50)
	@NotEmpty
	@Length(min = 10, max = 50)
	private String nroSerie;

	@Column(name = "TIPO", nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoEquipamento tipoEquipamento;

	@Column(name = "DESCRICAO", nullable = false, length = 255)
	@NotEmpty
	@Length(min = 10, max = 255)
	private String descricao;

	public Equipamento() {
	}

	public Equipamento(String nroSerie, TipoEquipamento tipoEquipamento, String descricao) {
		setNroSerie(nroSerie);
		setTipoEquipamento(tipoEquipamento);
		setDescricao(descricao);
	}

	public Equipamento(Integer id, String nroSerie, TipoEquipamento tipoEquipamento, String descricao) {
		setId(id);
		setNroSerie(nroSerie);
		setTipoEquipamento(tipoEquipamento);
		setDescricao(descricao);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNroSerie() {
		return nroSerie;
	}

	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}

	public TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nroSerie == null) ? 0 : nroSerie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Equipamento other = (Equipamento) obj;
		if (nroSerie == null) {
			if (other.nroSerie != null)
				return false;
		} else if (!nroSerie.equals(other.nroSerie))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipamento [id=" + getId() + ", nroSerie=" + getNroSerie() + ", tipoEquipamento="
				+ getTipoEquipamento() + ", descricao=" + getDescricao() + "]";
	}

}
