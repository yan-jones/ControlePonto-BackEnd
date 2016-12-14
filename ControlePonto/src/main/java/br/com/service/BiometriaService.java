package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.BiometriaDAO;

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

}
