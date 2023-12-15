package com.mx.Empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Empresa.dao.IEmpresaDao;
import com.mx.Empresa.entity.Empresa;
import com.mx.Empresa.model.Departamento;
import com.mx.Empresa.model.Empleado;

@SuppressWarnings("unchecked")
@Service
public class EmpresaService {
	@Autowired
	private IEmpresaDao dao;
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * METODOS DE LA EMPRESA
	 */
	public List<Empresa> getAll(){
		return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public Empresa save(Empresa empresa) {
		Empresa nuevaEmpresa = dao.save(empresa);
		return nuevaEmpresa;
	}
	
	public Empresa getEmpresaById(int id) {
		return dao.findById(id).orElse(null);
	}
	
	/**
	 * METODOS EMPLEADO
	 */
	public List<Empleado> getEmpleados() {
		List<Empleado> empresas = restTemplate.getForObject(
				"http://localhost:8032/Empleados", List.class);
		
		return empresas;
	}
	
	public Empleado save(Empleado empleado) {
		return restTemplate.postForObject(
				"http://localhost:8032/Empleados", empleado, Empleado.class);
	}
	
	/**
	 * METODOS DEPARTAMENTO
	 */
	public List<Departamento> getDepartamentos(){
		List<Departamento> departamento = restTemplate.getForObject(
				"http://localhost:8031/Departamentos", List.class);
		return departamento;
	}
	
	public Departamento save(Departamento departamento) {
		return restTemplate.postForObject(
				"http://localhost:8031/Departamentos", departamento, Departamento.class);
	
	}
}