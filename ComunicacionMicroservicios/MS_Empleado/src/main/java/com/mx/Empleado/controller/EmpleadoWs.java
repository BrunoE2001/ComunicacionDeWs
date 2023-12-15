package com.mx.Empleado.controller;

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

import com.mx.Empleado.entity.Empleado;
import com.mx.Empleado.service.EmpleadoService;

@RestController
@RequestMapping(path = "Empleados")
@CrossOrigin
public class EmpleadoWs {

	@Autowired
	private EmpleadoService service;
	
	@GetMapping
	public ResponseEntity<List<Empleado>> listarEmpleados(){
		List<Empleado> empleados = service.getAll();
		if (empleados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(empleados);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empleado));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable("id") int id){
		Empleado empleado = service.getEmpleado(id); 
		if (empleado == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(empleado);
	}
	
	@GetMapping("/Empresa/{empresaId}")
	public ResponseEntity<List<Empleado>> listarEmpleadoPorEmpresaId(@PathVariable("empresaId") int empresaId){
		List<Empleado> empleados = service.findByEmpresaId(empresaId);
		if (empleados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(empleados);
	}
}
