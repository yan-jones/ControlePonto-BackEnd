package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dao.EquipamentoDAO;
import br.com.entity.Equipamento;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoDAO equipamentoDAO;

	public EquipamentoDAO getEquipamentoDAO() {
		return equipamentoDAO;
	}

	public void setEquipamentoDAO(EquipamentoDAO equipamentoDAO) {
		this.equipamentoDAO = equipamentoDAO;
	}

	public ResponseEntity<Object> add(Equipamento dados) {
		try {
			Equipamento equipamento = getEquipamentoDAO().save(dados);
			return new ResponseEntity<Object>(equipamento, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> update(Equipamento dados) {
		try {
			Equipamento equipamento = getEquipamentoDAO().findOne(dados.getId());

			// Dados do objeto Equipamento
			equipamento.setNroSerie(dados.getNroSerie());
			equipamento.setTipoEquipamento(dados.getTipoEquipamento());
			equipamento.setDescricao(dados.getDescricao());

			equipamento = getEquipamentoDAO().save(equipamento);

			return new ResponseEntity<Object>(equipamento, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> delete(Integer id) {
		try {
			getEquipamentoDAO().delete(id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getEquipamento(Integer id) {
		try {
			Equipamento equipamento = getEquipamentoDAO().findOne(id);
			return new ResponseEntity<Object>(equipamento, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getAll() {
		try {
			List<Equipamento> equipamentos = (List<Equipamento>) getEquipamentoDAO().findAll();
			return new ResponseEntity<Object>(equipamentos, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
