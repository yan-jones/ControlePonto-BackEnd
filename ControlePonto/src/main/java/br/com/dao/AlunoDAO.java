package br.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Aluno;

@Repository
public interface AlunoDAO extends CrudRepository<Aluno, Integer> {

}
