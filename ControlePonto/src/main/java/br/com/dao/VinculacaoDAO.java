package br.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Vinculacao;

@Repository
public interface VinculacaoDAO extends CrudRepository<Vinculacao, Integer> {

}
