package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.UtilService;

@RestController
@RequestMapping(value = "/util")
public class UtilController {

	@Autowired
	private UtilService utilService;

	public UtilService getUtilService() {
		return utilService;
	}

	public void setUtilService(UtilService utilService) {
		this.utilService = utilService;
	}

	@RequestMapping(value = { "/perfis" }, method = RequestMethod.GET)
	public ResponseEntity<Object> getPerfis() {
		return getUtilService().getPerfis();
	}

	@RequestMapping(value = { "/sexos" }, method = RequestMethod.GET)
	public ResponseEntity<Object> getSexos() {
		return getUtilService().getSexos();
	}

	@RequestMapping(value = { "/status" }, method = RequestMethod.GET)
	public ResponseEntity<Object> getStatus() {
		return getUtilService().getStatus();
	}

	@RequestMapping(value = { "/tiposConta" }, method = RequestMethod.GET)
	public ResponseEntity<Object> getTiposConta() {
		return getUtilService().getTiposConta();
	}

	@RequestMapping(value = { "/tiposEmail" }, method = RequestMethod.GET)
	public ResponseEntity<Object> getTiposEmail() {
		return getUtilService().getTiposEmail();
	}

	@RequestMapping(value = { "/tiposEquipamento" }, method = RequestMethod.GET)
	public ResponseEntity<Object> getTiposEquipamento() {
		return getUtilService().getTiposEquipamento();
	}

	@RequestMapping(value = { "/titulacoes" }, method = RequestMethod.GET)
	public ResponseEntity<Object> getTitutacoes() {
		return getUtilService().getTitutacoes();
	}

	@RequestMapping(value = { "/ufs" }, method = RequestMethod.GET)
	public ResponseEntity<Object> getUfs() {
		return getUtilService().getUfs();
	}

}
