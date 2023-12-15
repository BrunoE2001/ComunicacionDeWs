package com.mx.Empresa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Empresa.entity.Empresa;

public interface IEmpresaDao extends JpaRepository<Empresa, Integer>{

}
