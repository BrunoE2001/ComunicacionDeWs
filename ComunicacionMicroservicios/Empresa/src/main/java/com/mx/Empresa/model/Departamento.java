package com.mx.Empresa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Departamento {
	private int id;
	private String nombre;
	private int noEmpleados;
	private int empresaId;
}
