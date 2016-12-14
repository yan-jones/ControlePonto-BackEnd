package br.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Conta;

@Repository
public interface ContaDAO extends CrudRepository<Conta, Integer> {

}
