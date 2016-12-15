package br.com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.enumeration.Perfil;
import br.com.enumeration.Sexo;
import br.com.enumeration.Status;

@Entity
@Table(name = "PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
// @NamedQueries({
// @NamedQuery(name = "ComboPessoas", query = "select new Pessoa(p.id, p.nome,
// p.perfil) from Pessoa p order by p.nome"),
// @NamedQuery(name = "RelatorioPorPerfil", query = "select new Pessoa(p.id,
// p.nome, p.cpf, p.email, p.dataNascimento, p.sexo, p.perfil) from Pessoa p
// where p.status = ?1 order by p.perfil") })
@JsonInclude(value = Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4252320501078312721L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PESSOA", nullable = false)
	private Integer id;

	@Column(name = "NOME", nullable = false, length = 255)
	@NotEmpty
	@Length(min = 3, max = 255)
	private String nome;

	@Column(name = "SENHA", nullable = false, length = 20)
	@NotEmpty
	@Pattern(regexp = "(?=.*[A-Z]).{8,15}$")
	private String senha;

	@Column(name = "CPF", nullable = false, length = 11)
	@NotEmpty
	@CPF
	private String cpf;

	@Column(name = "RG", nullable = false, length = 10)
	@NotEmpty
	@Length(min = 5, max = 10)
	private String rg;

	@Column(name = "EMAIL", nullable = false, length = 100)
	@NotEmpty
	@Email
	private String email;

	@Column(name = "DATA_NASCIMENTO", nullable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",
	// timezone = "GMT-3")
	@NotNull
	@Past
	private Timestamp dataNascimento;

	@Column(name = "SEXO", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Sexo sexo;

	@Column(name = "PERFIL", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Perfil perfil;

	@Column(name = "STATUS", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Status status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO", nullable = false)
	@NotNull
	private Endereco endereco;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CONTA", nullable = false)
	@NotNull
	private Conta conta;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_BIOMETRIA", nullable = false)
	@NotNull
	private Biometria biometria;

	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, Perfil perfil) {
		setId(id);
		setNome(nome);
		setPerfil(perfil);
	}

	public Pessoa(Integer id, String nome, String cpf, String email, Timestamp dataNascimento, Sexo sexo,
			Perfil perfil) {
		setId(id);
		setNome(nome);
		setCpf(cpf);
		setEmail(email);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setPerfil(perfil);
	}

	public Pessoa(String nome, String senha, String cpf, String rg, String email, Timestamp dataNascimento, Sexo sexo,
			Perfil perfil, Status status, Endereco endereco, Conta conta, Biometria biometria) {
		setNome(nome);
		setSenha(senha);
		setCpf(cpf);
		setRg(rg);
		setEmail(email);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setPerfil(perfil);
		setStatus(status);
		setEndereco(endereco);
		setConta(conta);
		setBiometria(biometria);
	}

	public Pessoa(Integer id, String nome, String senha, String cpf, String rg, String email, Timestamp dataNascimento,
			Sexo sexo, Perfil perfil, Status status, Endereco endereco, Conta conta, Biometria biometria) {
		setId(id);
		setNome(nome);
		setSenha(senha);
		setCpf(cpf);
		setRg(rg);
		setEmail(email);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setPerfil(perfil);
		setStatus(status);
		setEndereco(endereco);
		setConta(conta);
		setBiometria(biometria);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Timestamp dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
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
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + getId() + ", nome=" + getNome() + ", senha=" + getSenha() + ", cpf=" + getCpf() + ", rg="
				+ getRg() + ", email=" + getEmail() + ", dataNascimento=" + getDataNascimento() + ", sexo=" + getSexo()
				+ ", perfil=" + getPerfil() + ", status=" + getStatus() + ", endereco=" + getEndereco() + ", conta="
				+ getConta() + ", biometria=" + getBiometria() + "]";
	}

}
