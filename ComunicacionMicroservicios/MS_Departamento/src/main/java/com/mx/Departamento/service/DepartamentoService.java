package com.mx.Departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Departamento.dao.IDepartamentoDao;
import com.mx.Departamento.entity.Departamento;

@Service
public class DepartamentoService {
	@Autowired
	private IDepartamentoDao dao;
	
	public List<Departamento> listar(){
		return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public Departamento getCliente(int id) {
		return dao.findById(id).orElse(null);
	}
	
	public Departamento save(Departamento departamento) {
		return dao.save(departamento);
	}
	
	public List<Departamento> byDepartamentoId(int departamentoId){
		return dao.findByEmpresaId(departamentoId);
	}
}
