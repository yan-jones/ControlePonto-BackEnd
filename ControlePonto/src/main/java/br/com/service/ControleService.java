package br.com.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dao.BiometriaDAO;
import br.com.dao.ControleDAO;
import br.com.entity.Biometria;
import br.com.entity.Controle;

@Service
public class ControleService {

	@Autowired
	private ControleDAO controleDAO;

	@Autowired
	private BiometriaDAO biometriaDAO;

	public ControleDAO getControleDAO() {
		return controleDAO;
	}

	public void setControleDAO(ControleDAO controleDAO) {
		this.controleDAO = controleDAO;
	}

	public BiometriaDAO getBiometriaDAO() {
		return biometriaDAO;
	}

	public void setBiometriaDAO(BiometriaDAO biometriaDAO) {
		this.biometriaDAO = biometriaDAO;
	}

	public boolean validaDataEntradaSemDataSaida(Biometria biometria) {
		Controle controle = getControleDAO().findTop1ByBiometriaIdOrderByIdDesc(biometria);
		System.out.println(controle);
		if (controle.getDataSaida() != null)
			return false;
		return true;
	}

	public ResponseEntity<Object> setDataEntrada(Biometria dados) {
		try {
			// Calendar dataAtual = Calendar.getInstance();
			Timestamp dataAtual = new Timestamp(System.currentTimeMillis());
			Biometria biometria = getBiometriaDAO().findByNumero(dados.getNumero());
			// if (validaDataEntradaSemDataSaida(biometria)) {
			Controle controle = new Controle(dataAtual, biometria);
			controle = getControleDAO().save(controle);
			return new ResponseEntity<Object>(controle, HttpStatus.CREATED);
			// }
			// return new ResponseEntity<Object>(
			// "Não pode realizar dois registros de entrada sem registrar o
			// registro da saída!", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> setDataSaida(Controle dados) {
		try {
			// Calendar dataAtual = Calendar.getInstance();
			Timestamp dataAtual = new Timestamp(System.currentTimeMillis());
			Controle controle = getControleDAO().findOne(dados.getId());
			// if (validaDataSaidaSemDataEntrada(biometria)) {
			controle.setDataSaida(dataAtual);
			controle = getControleDAO().save(controle);
			return new ResponseEntity<Object>(controle, HttpStatus.CREATED);
			// }
			// return new ResponseEntity<Object>("Não pode realizar saída se não
			// teve entrada!", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getControle(Integer id) {
		try {
			Controle controle = getControleDAO().findOne(id);
			return new ResponseEntity<Object>(controle, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getAll() {
		try {
			List<Controle> controle = (List<Controle>) getControleDAO().findAll();
			return new ResponseEntity<Object>(controle, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
