package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.VinculacaoDAO;

@Service
public class VinculacaoService {

	@Autowired
	private VinculacaoDAO vinculacaoDAO;

	public VinculacaoDAO getVinculacaoDAO() {
		return vinculacaoDAO;
	}

	public void setVinculacaoDAO(VinculacaoDAO vinculacaoDAO) {
		this.vinculacaoDAO = vinculacaoDAO;
	}

}
