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
import br.com.entity.Controle;
import br.com.service.ControleService;

@RestController
@RequestMapping(value = "/controle")
public class ControleController {

	@Autowired
	private ControleService controleService;

	public ControleService getControleService() {
		return controleService;
	}

	public void setControleService(ControleService controleService) {
		this.controleService = controleService;
	}

	@RequestMapping(value = { "/dataEntrada" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> setDataEntrada(@RequestBody Biometria biometria) {
		return getControleService().setDataEntrada(biometria);
	}

	@RequestMapping(value = { "/dataSaida" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> setDataSaida(@RequestBody Controle controle) {
		return getControleService().setDataSaida(controle);
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getControle(@PathVariable("id") Integer id) {
		return getControleService().getControle(id);
	}
	
	@RequestMapping(value = { "/controles" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getAll() {
		return getControleService().getAll();
	}

}
