package com.mx.Empleado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Empleado.dao.IEmpleadoDao;
import com.mx.Empleado.entity.Empleado;

@Service
public class EmpleadoService {
	@Autowired
	private IEmpleadoDao dao;
	
	public List<Empleado> getAll() {
		return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public Empleado getEmpleado(int id){
		return dao.findById(id).orElse(null);
	}
	
	public Empleado save(Empleado empleado) {
		return dao.save(empleado);
	}

	public List<Empleado> findByEmpresaId(int empresaId){
		return dao.findByEmpresaId(empresaId);
	}
}
