package br.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Biometria;
import br.com.entity.Controle;

@Repository
public interface ControleDAO extends CrudRepository<Controle, Integer> {

	public Controle findTop1ByBiometriaIdOrderByIdDesc(Biometria biometria);

//	@Query("select new Controle(c.biometria.numero, c.biometria.pessoa.nome, c.id, c.dataEntrada, c.dataSaida) "
//			+ "from Controle c where c.dataEntrada between ?1 and ?2 and c.dataSaida between ?1 and ?2 "
//			+ "order by c.dataSaida desc")
//	public List<Controle> relatorioPresenca();
}
