package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Funcionario;
import br.com.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

	@Autowired
	protected FuncionarioService funcionarioService;

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> add(@RequestBody Funcionario funcionario) {
		return getFuncionarioService().add(funcionario);
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> update(@RequestBody Funcionario funcionario) {
		return getFuncionarioService().update(funcionario);
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		return getFuncionarioService().delete(id);
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getFuncionario(@PathVariable("id") Integer id) {
		return getFuncionarioService().getFuncionario(id);
	}

	@RequestMapping(value = { "/funcionarios" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getAll() {
		return getFuncionarioService().getAll();
	}

}
