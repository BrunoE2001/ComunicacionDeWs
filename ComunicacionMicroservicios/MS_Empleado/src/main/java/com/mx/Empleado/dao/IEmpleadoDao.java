package com.mx.Empleado.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Empleado.entity.Empleado;

public interface IEmpleadoDao extends JpaRepository<Empleado, Integer>{

	// METODO PERSONALIZADO
	public List<Empleado> findByEmpresaId(int empresaId);
}
