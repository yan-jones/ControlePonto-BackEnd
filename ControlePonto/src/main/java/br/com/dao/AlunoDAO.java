package br.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Aluno;

@Repository
public interface AlunoDAO extends CrudRepository<Aluno, Integer> {

	@Query("select new Aluno(a.nome, a.cpf, a.nroKit, a.turma, a.conta.numero, a.conta.agencia, a.email, "
			+ "a.dataNascimento, a.sexo from Aluno a where a.status = ?1 order by a.nome)")
	public List<Aluno> relatorioAlunos();

	@Query("from Aluno a where a.status = ?1 order by a.nome")
	public List<Aluno> relatorioAlunosEquipamentos();
}
