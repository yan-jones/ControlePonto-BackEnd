package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dao.FuncionarioDAO;
import br.com.entity.Funcionario;

@Service
public class FuncionarioService {

	@Autowired
	protected FuncionarioDAO funcionarioDAO;

	public FuncionarioDAO getFuncionarioDAO() {
		return funcionarioDAO;
	}

	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}

	public ResponseEntity<Object> add(Funcionario dados) {
		try {
			Funcionario funcionario = getFuncionarioDAO().save(dados);
			return new ResponseEntity<Object>(funcionario, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> update(Funcionario dados) {
		try {
			Funcionario funcionario = getFuncionarioDAO().findOne(dados.getId());
			// modifica os atributos que possam ser alterados
			funcionario = getFuncionarioDAO().save(funcionario);
			return new ResponseEntity<Object>(funcionario, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> delete(Integer id) {
		try {
			getFuncionarioDAO().delete(id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getFuncionario(Integer id) {
		try {
			Funcionario funcionario = getFuncionarioDAO().findOne(id);
			return new ResponseEntity<Object>(funcionario, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getAll() {
		try {
			List<Funcionario> funcionarios = (List<Funcionario>) getFuncionarioDAO().findAll();
			return new ResponseEntity<Object>(funcionarios, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
