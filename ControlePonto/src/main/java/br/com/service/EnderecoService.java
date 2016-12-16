package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dao.EnderecoDAO;
import br.com.entity.Endereco;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoDAO enderecoDAO;

	public EnderecoDAO getEnderecoDAO() {
		return enderecoDAO;
	}

	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	public ResponseEntity<Endereco> add(Endereco endereco) {
		try {
			endereco = getEnderecoDAO().save(endereco);
			return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return new ResponseEntity<Endereco>(HttpStatus.BAD_REQUEST);
	}

}
