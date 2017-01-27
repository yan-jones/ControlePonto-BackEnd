package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Vinculacao;
import br.com.service.VinculacaoService;

@RestController
@RequestMapping(value = "/vinculacao")
public class VinculacaoController {

	@Autowired
	private VinculacaoService vinculacaoService;

	public VinculacaoService getVinculacaoService() {
		return vinculacaoService;
	}

	public void setVinculacaoService(VinculacaoService vinculacaoService) {
		this.vinculacaoService = vinculacaoService;
	}

	@PostMapping(value = { "/add" })
	public ResponseEntity<Object> add(@RequestBody Vinculacao vinculacao) {
		return getVinculacaoService().add(vinculacao);
	}

	@PutMapping(value = { "/update" })
	public ResponseEntity<Object> update(@RequestBody Vinculacao vinculacao) {
		return getVinculacaoService().update(vinculacao);
	}

	@GetMapping(value = { "/{id}" })
	public ResponseEntity<Object> getVinculacao(@PathVariable("id") Integer id) {
		return getVinculacaoService().getAluno(id);
	}

	@GetMapping(value = { "/" })
	public ResponseEntity<Object> getAll() {
		return getVinculacaoService().getAll();
	}

}
