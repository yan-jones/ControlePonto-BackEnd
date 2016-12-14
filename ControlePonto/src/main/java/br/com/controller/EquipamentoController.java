package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.EquipamentoService;

@RestController
@RequestMapping(value = "/equipamento")
public class EquipamentoController {

	@Autowired
	protected EquipamentoService equipamentoService;

	public EquipamentoService getEquipamentoService() {
		return equipamentoService;
	}

	public void setEquipamentoService(EquipamentoService equipamentoService) {
		this.equipamentoService = equipamentoService;
	}

}
