package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.ControleDAO;

@Service
public class ControleService {

	@Autowired
	protected ControleDAO controleDAO;

	public ControleDAO getControleDAO() {
		return controleDAO;
	}

	public void setControleDAO(ControleDAO controleDAO) {
		this.controleDAO = controleDAO;
	}

}
