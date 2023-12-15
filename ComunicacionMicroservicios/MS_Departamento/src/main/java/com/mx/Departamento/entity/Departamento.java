package com.mx.Departamento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEPARTAMENTO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Departamento {
	@Id
	private int id;
	private String nombre;
	private int noEmpleados;
	private int empresaId;
}
