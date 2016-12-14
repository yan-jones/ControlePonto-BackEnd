package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.BiometriaService;

@RestController
@RequestMapping(value = "/biometria")
public class BiometriaController {

	@Autowired
	protected BiometriaService biometriaService;

	public BiometriaService getBiometriaService() {
		return biometriaService;
	}

	public void setBiometriaService(BiometriaService biometriaService) {
		this.biometriaService = biometriaService;
	}

}
