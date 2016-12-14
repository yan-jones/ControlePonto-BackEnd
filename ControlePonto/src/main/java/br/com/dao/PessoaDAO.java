package br.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Pessoa;

@Repository
public interface PessoaDAO extends CrudRepository<Pessoa, Integer> {

}
