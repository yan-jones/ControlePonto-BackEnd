package br.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Funcionario;

@Repository
public interface FuncionarioDAO extends CrudRepository<Funcionario, Integer> {

}
