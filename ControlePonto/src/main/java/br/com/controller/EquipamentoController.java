package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Equipamento;
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

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> add(@RequestBody Equipamento equipamento) {
		return getEquipamentoService().add(equipamento);
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> update(@RequestBody Equipamento equipamento) {
		return getEquipamentoService().update(equipamento);
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		return getEquipamentoService().delete(id);
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getEquipamento(@PathVariable("id") Integer id) {
		return getEquipamentoService().getEquipamento(id);
	}

	@RequestMapping(value = { "/equipamentos" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getAll() {
		return getEquipamentoService().getAll();
	}

}
