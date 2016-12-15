package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Aluno;
import br.com.service.AlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

	@Autowired
	protected AlunoService alunoService;

	public AlunoService getAlunoService() {
		return alunoService;
	}

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> add(@RequestBody Aluno aluno) {
		return getAlunoService().add(aluno);
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> update(@RequestBody Aluno aluno) {
		return getAlunoService().update(aluno);
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		return getAlunoService().delete(id);
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getAluno(@PathVariable("id") Integer id) {
		return getAlunoService().getAluno(id);
	}

	@RequestMapping(value = { "/alunos" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getAll() {
		return getAlunoService().getAll();
	}
}
