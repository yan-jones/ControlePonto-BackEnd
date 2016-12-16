package br.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Biometria;
import br.com.entity.Controle;

@Repository
public interface ControleDAO extends CrudRepository<Controle, Integer> {

	public Controle findTop1ByBiometriaIdOrderByIdDesc(Biometria biometria);
}
