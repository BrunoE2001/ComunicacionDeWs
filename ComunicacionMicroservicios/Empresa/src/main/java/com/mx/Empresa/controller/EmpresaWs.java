package com.mx.Empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Empresa.entity.Empresa;
import com.mx.Empresa.model.Departamento;
import com.mx.Empresa.model.Empleado;
import com.mx.Empresa.service.EmpresaService;

@RestController
@RequestMapping(path = "/Empresa")
@CrossOrigin
public class EmpresaWs {
	@Autowired
	private EmpresaService service;
	
	@GetMapping
	public ResponseEntity<List<Empresa>> listarEmpresa(){
		List<Empresa> empresa = service.getAll();
		if (empresa.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(empresa);
		}
	}
	
	@PostMapping
	public ResponseEntity<Empresa> guardarEmpresa(@RequestBody Empresa empresa){
		Empresa nuevaEmpresa = service.save(empresa);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEmpresa);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> obtenerEmpresa(@PathVariable("id") int id){
		Empresa empresa = service.getEmpresaById(id);
		if (empresa == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(empresa);
		}
	}
	
	/**
	 * SERVICIOS DE EMPLEADOS
	 */
	@GetMapping("/Empleados")
	public ResponseEntity<List<Empleado>> listarEmpleados(){
		List<Empleado> empleado = service.getEmpleados();
		if (empleado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(empleado);
		}
	}
	
	@PostMapping("/Empleados/")
	public ResponseEntity<Empleado> guardarEmpleados(@RequestBody Empleado empleado){
		Empleado nEmpleado = service.save(empleado);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nEmpleado); 
	}
	
	/**
	 * SERVICIOS DE DEPARTAMENTO
	 */
	@GetMapping("/Departamentos")
	public ResponseEntity<List<Departamento>> listarDepartamentos(){
		List<Departamento> depa = service.getDepartamentos();
		if (depa.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(depa);
		}
	}
	
	@PostMapping("Departamentos")
	public ResponseEntity<Departamento> guardarDepartamento(@RequestBody Departamento departamento){
		Departamento nDepartamento = service.save(departamento); 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nDepartamento);
	}
}
