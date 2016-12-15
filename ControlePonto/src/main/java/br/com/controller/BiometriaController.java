package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Biometria;
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

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> add(@RequestBody Biometria biometria) {
		return getBiometriaService().add(biometria);
	}

	// @RequestMapping(value = { "/update" }, method = RequestMethod.PUT)
	// @ResponseBody
	// public ResponseEntity<Object> update(@RequestBody Biometria biometria) {
	// return getBiometriaService().update(biometria);
	// }

//	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
//	@ResponseBody
//	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
//		return getBiometriaService().delete(id);
//	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getBiometria(@PathVariable("id") Integer id) {
		return getBiometriaService().getBiometria(id);
	}

	@RequestMapping(value = { "/biometrias" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getAll() {
		return getBiometriaService().getAll();
	}

}
