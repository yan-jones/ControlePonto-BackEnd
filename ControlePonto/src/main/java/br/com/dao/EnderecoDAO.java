package br.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Endereco;

@Repository
public interface EnderecoDAO extends CrudRepository<Endereco, Integer> {

}
