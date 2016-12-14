package br.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Equipamento;

@Repository
public interface EquipamentoDAO extends CrudRepository<Equipamento, Integer> {

}
