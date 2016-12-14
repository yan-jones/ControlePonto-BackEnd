package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.ControleService;

@RestController
@RequestMapping(value = "/controle")
public class ControleController {

	@Autowired
	protected ControleService controleService;

	public ControleService getControleService() {
		return controleService;
	}

	public void setControleService(ControleService controleService) {
		this.controleService = controleService;
	}

}
