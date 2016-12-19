package br.com.service;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.enumeration.Perfil;
import br.com.enumeration.Sexo;
import br.com.enumeration.Status;
import br.com.enumeration.TipoConta;
import br.com.enumeration.TipoEmail;
import br.com.enumeration.TipoEquipamento;
import br.com.enumeration.Titulacao;
import br.com.enumeration.Uf;

@Service
public class UtilService {

	public ResponseEntity<Object> getPerfis() {
		try {
			List<Perfil> perfis = Arrays.asList(Perfil.values());
			Set<Map<String, Object>> resposta = new LinkedHashSet<Map<String, Object>>();
			for (Perfil perfil : perfis) {
				Map<String, Object> mapPerfis = new Hashtable<String, Object>();
				mapPerfis.put("id", perfil.ordinal() + 1);
				mapPerfis.put("descricao", perfil.name());
				resposta.add(mapPerfis);
			}
			return new ResponseEntity<Object>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getSexos() {
		try {
			List<Sexo> sexos = Arrays.asList(Sexo.values());
			Set<Map<String, Object>> resposta = new LinkedHashSet<Map<String, Object>>();
			for (Sexo sexo : sexos) {
				Map<String, Object> mapSexos = new Hashtable<String, Object>();
				mapSexos.put("id", sexo.ordinal() + 1);
				mapSexos.put("descricao", sexo.name());
				resposta.add(mapSexos);
			}
			return new ResponseEntity<Object>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getStatus() {
		try {
			List<Status> status = Arrays.asList(Status.values());
			Set<Map<String, Object>> resposta = new LinkedHashSet<Map<String, Object>>();
			for (Status s : status) {
				Map<String, Object> mapStatus = new Hashtable<String, Object>();
				mapStatus.put("id", s.ordinal() + 1);
				mapStatus.put("descricao", s.name());
				resposta.add(mapStatus);
			}
			return new ResponseEntity<Object>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getTiposConta() {
		try {
			List<TipoConta> tiposConta = Arrays.asList(TipoConta.values());
			Set<Map<String, Object>> resposta = new LinkedHashSet<Map<String, Object>>();
			for (TipoConta tipoConta : tiposConta) {
				Map<String, Object> mapTipoConta = new Hashtable<String, Object>();
				mapTipoConta.put("id", tipoConta.ordinal() + 1);
				mapTipoConta.put("descricao", tipoConta.name());
				resposta.add(mapTipoConta);
			}
			return new ResponseEntity<Object>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getTiposEmail() {
		try {
			List<TipoEmail> tiposEmail = Arrays.asList(TipoEmail.values());
			Set<Map<String, Object>> resposta = new LinkedHashSet<Map<String, Object>>();
			for (TipoEmail tipoEmail : tiposEmail) {
				Map<String, Object> mapTipoEmail = new Hashtable<String, Object>();
				mapTipoEmail.put("id", tipoEmail.ordinal() + 1);
				mapTipoEmail.put("descricao", tipoEmail.name());
				resposta.add(mapTipoEmail);
			}
			return new ResponseEntity<Object>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getTiposEquipamento() {
		try {
			List<TipoEquipamento> tiposEquipamento = Arrays.asList(TipoEquipamento.values());
			Set<Map<String, Object>> resposta = new LinkedHashSet<Map<String, Object>>();
			for (TipoEquipamento tipoEquipamento : tiposEquipamento) {
				Map<String, Object> mapTipoEquipamento = new Hashtable<String, Object>();
				mapTipoEquipamento.put("id", tipoEquipamento.ordinal() + 1);
				mapTipoEquipamento.put("descricao", tipoEquipamento.name());
				resposta.add(mapTipoEquipamento);
			}
			return new ResponseEntity<Object>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getTitutacoes() {
		try {
			List<Titulacao> titulacoes = Arrays.asList(Titulacao.values());
			Set<Map<String, Object>> resposta = new LinkedHashSet<Map<String, Object>>();
			for (Titulacao titulacao : titulacoes) {
				Map<String, Object> mapTitulacao = new Hashtable<String, Object>();
				mapTitulacao.put("id", titulacao.ordinal() + 1);
				mapTitulacao.put("descricao", titulacao.name());
				resposta.add(mapTitulacao);
			}
			return new ResponseEntity<Object>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> getUfs() {
		try {
			List<Uf> ufs = Arrays.asList(Uf.values());
			Set<Map<String, Object>> resposta = new LinkedHashSet<Map<String, Object>>();
			for (Uf uf : ufs) {
				Map<String, Object> mapUf = new Hashtable<String, Object>();
				mapUf.put("id", uf.ordinal() + 1);
				mapUf.put("descricao", uf.name());
				resposta.add(mapUf);
			}
			return new ResponseEntity<Object>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
