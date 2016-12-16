package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.ContaDAO;

@Service
public class ContaService {

	@Autowired
	private ContaDAO contaDAO;

	public ContaDAO getContaDAO() {
		return contaDAO;
	}

	public void setContaDAO(ContaDAO contaDAO) {
		this.contaDAO = contaDAO;
	}

}
