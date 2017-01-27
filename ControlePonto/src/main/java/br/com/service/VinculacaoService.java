package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dao.VinculacaoDAO;
import br.com.entity.Vinculacao;

@Service
public class VinculacaoService {

	@Autowired
	private VinculacaoDAO vinculacaoDAO;

	public VinculacaoDAO getVinculacaoDAO() {
		return vinculacaoDAO;
	}

	public void setVinculacaoDAO(VinculacaoDAO vinculacaoDAO) {
		this.vinculacaoDAO = vinculacaoDAO;
	}

	public ResponseEntity<Object> add(Vinculacao dados) {
		try {
			// validação para a data início não ser menor que a data final
			Vinculacao vinculacao = getVinculacaoDAO().save(dados);
			return new ResponseEntity<Object>(vinculacao, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> update(Vinculacao dados) {
		try {
			Vinculacao vinculacao = getVinculacaoDAO().findOne(dados.getId());

			// validação para a data início não ser menor que a data final

			// Os atributos não alterados
			// id, pessoa, equipamento

			// Dados da vinculação
			vinculacao.setDataInicio(dados.getDataInicio());
			vinculacao.setDataFinal(dados.getDataFinal());

			vinculacao = getVinculacaoDAO().save(vinculacao);

			return new ResponseEntity<Object>(vinculacao, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getAluno(Integer id) {
		try {
			Vinculacao vinculacao = getVinculacaoDAO().findOne(id);
			return new ResponseEntity<Object>(vinculacao, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getAll() {
		try {
			List<Vinculacao> vinculacoes = (List<Vinculacao>) getVinculacaoDAO().findAll();
			return new ResponseEntity<Object>(vinculacoes, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
