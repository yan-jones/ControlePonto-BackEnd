package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Endereco;
import br.com.enumeration.Uf;
import br.com.service.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	public EnderecoService getEnderecoService() {
		return enderecoService;
	}

	public void setEnderecoService(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ResponseEntity<Endereco> add() {
		return getEnderecoService().add(new Endereco(1, "12345678", "teste", "teste", "teste", "teste", Uf.DF));
	}

}
