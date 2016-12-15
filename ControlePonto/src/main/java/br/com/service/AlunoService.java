package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dao.AlunoDAO;
import br.com.entity.Aluno;

@Service
public class AlunoService {

	@Autowired
	protected AlunoDAO alunoDAO;

	public AlunoDAO getAlunoDAO() {
		return alunoDAO;
	}

	public void setAlunoDAO(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public ResponseEntity<Object> add(Aluno dados) {
		try {
			Aluno aluno = getAlunoDAO().save(dados);
			return new ResponseEntity<Object>(aluno, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> update(Aluno dados) {
		try {
			Aluno aluno = getAlunoDAO().findOne(dados.getId());

			// Os atributos não alterados
			// id, senha, email e biometria
			// Dados do objeto Pessoa
			aluno.setNome(dados.getNome());
			aluno.setCpf(dados.getCpf());
			aluno.setRg(dados.getRg());
			aluno.setDataNascimento(dados.getDataNascimento());
			aluno.setSexo(dados.getSexo());
			aluno.setPerfil(dados.getPerfil());
			aluno.setStatus(dados.getStatus());
			// Dados do objeto Endereço
			aluno.getEndereco().setCep(dados.getEndereco().getCep());
			aluno.getEndereco().setDescricao(dados.getEndereco().getDescricao());
			aluno.getEndereco().setBairro(dados.getEndereco().getBairro());
			aluno.getEndereco().setCidade(dados.getEndereco().getCidade());
			aluno.getEndereco().setComplemento(dados.getEndereco().getComplemento());
			aluno.getEndereco().setUf(dados.getEndereco().getUf());
			// Dados do objeto Conta
			aluno.getConta().setNumero(dados.getConta().getNumero());
			aluno.getConta().setAgencia(dados.getConta().getAgencia());
			aluno.getConta().setTipoConta(dados.getConta().getTipoConta());
			// Dados do objeto Aluno
			aluno.setNroKit(dados.getNroKit());
			aluno.setTurma(dados.getTurma());

			aluno = getAlunoDAO().save(aluno);

			return new ResponseEntity<Object>(aluno, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> delete(Integer id) {
		try {
			getAlunoDAO().delete(id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getAluno(Integer id) {
		try {
			Aluno aluno = getAlunoDAO().findOne(id);
			return new ResponseEntity<Object>(aluno, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getAll() {
		try {
			List<Aluno> alunos = (List<Aluno>) getAlunoDAO().findAll();
			return new ResponseEntity<Object>(alunos, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
