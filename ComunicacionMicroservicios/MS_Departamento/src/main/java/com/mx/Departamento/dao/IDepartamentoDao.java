package com.mx.Departamento.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Departamento.entity.Departamento;

public interface IDepartamentoDao extends JpaRepository<Departamento, Integer>{

	public List<Departamento> findByEmpresaId(int empresaId);
}
