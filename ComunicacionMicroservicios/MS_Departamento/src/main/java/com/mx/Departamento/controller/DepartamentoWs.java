package com.mx.Departamento.controller;

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

import com.mx.Departamento.entity.Departamento;
import com.mx.Departamento.service.DepartamentoService;

@RestController
@RequestMapping(path = "Departamentos")
@CrossOrigin
public class DepartamentoWs {
	@Autowired
	private DepartamentoService service;

	@GetMapping
	public ResponseEntity<List<Departamento>> listar(){
		List<Departamento> departamentos = service.listar();
		if (departamentos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(departamentos); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Departamento> guardar(@RequestBody Departamento departamento){
		Departamento nuevoDepa = service.save(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDepa);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> buscarId(@PathVariable("id") int id){
		Departamento departamento = service.getCliente(id);
		if (departamento == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(departamento);
		}
	}
	
	@GetMapping("/empresa/{empresaId}")
	public ResponseEntity<List<Departamento>> listarEmpresaPorId(@PathVariable("empresaId") int empresaId){
		List<Departamento> departamentos = service.byDepartamentoId(empresaId);
		if (departamentos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(departamentos);
		}
	}
}
