package br.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Pessoa;

@Repository
public interface PessoaDAO extends CrudRepository<Pessoa, Integer> {

	@Query("select new Pessoa(p.id, p.nome, p.perfil) from Pessoa p order by p.nome")
	public List<Pessoa> comboPessoa();

	public Pessoa findByCpfAndSenha(String cpf, String senha);

	public Pessoa findByEmail(String email);

	@Query("select new Pessoa(p.id, p.nome, p.cpf, p.email, p.dataNascimento, p.sexo, p.perfil) "
			+ "from Pessoa p where p.status = ?1 order by p.perfil")
	public List<Pessoa> relatorioPorPerfil();
}
