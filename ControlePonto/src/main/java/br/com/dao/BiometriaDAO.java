package br.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Biometria;

@Repository
public interface BiometriaDAO extends CrudRepository<Biometria, Integer> {

}
