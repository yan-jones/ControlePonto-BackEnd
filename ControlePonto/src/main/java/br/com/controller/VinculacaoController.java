package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.VinculacaoService;

@RestController
@RequestMapping(value = "/vinculacao")
public class VinculacaoController {

	@Autowired
	protected VinculacaoService vinculacaoService;

	public VinculacaoService getVinculacaoService() {
		return vinculacaoService;
	}

	public void setVinculacaoService(VinculacaoService vinculacaoService) {
		this.vinculacaoService = vinculacaoService;
	}

}
