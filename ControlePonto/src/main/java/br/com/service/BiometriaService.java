package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dao.BiometriaDAO;
import br.com.entity.Biometria;

@Service
public class BiometriaService {

	@Autowired
	protected BiometriaDAO biometriaDAO;

	public BiometriaDAO getBiometriaDAO() {
		return biometriaDAO;
	}

	public void setBiometriaDAO(BiometriaDAO biometriaDAO) {
		this.biometriaDAO = biometriaDAO;
	}

	public ResponseEntity<Object> add(Biometria dados) {
		try {
			Biometria biometria = getBiometriaDAO().save(dados);
			return new ResponseEntity<Object>(biometria, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	public ResponseEntity<Object> update(Biometria dados) {
//		try {
//			Biometria biometria = getBiometriaDAO().findOne(dados.getId());
//
//			// Dados do objeto Biometria
//			biometria.setNumero(dados.getNumero());
//
//			biometria = getBiometriaDAO().save(biometria);
//
//			return new ResponseEntity<Object>(biometria, HttpStatus.CREATED);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

//	public ResponseEntity<Object> delete(Integer id) {
//		try {
//			getBiometriaDAO().delete(id);
//			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	public ResponseEntity<Object> getBiometria(Integer id) {
		try {
			Biometria biometria = getBiometriaDAO().findOne(id);
			return new ResponseEntity<Object>(biometria, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getAll() {
		try {
			List<Biometria> biometrias = (List<Biometria>) getBiometriaDAO().findAll();
			return new ResponseEntity<Object>(biometrias, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
