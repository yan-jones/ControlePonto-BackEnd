package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.EquipamentoDAO;

@Service
public class EquipamentoService {

	@Autowired
	protected EquipamentoDAO equipamentoDAO;

	public EquipamentoDAO getEquipamentoDAO() {
		return equipamentoDAO;
	}

	public void setEquipamentoDAO(EquipamentoDAO equipamentoDAO) {
		this.equipamentoDAO = equipamentoDAO;
	}

}
