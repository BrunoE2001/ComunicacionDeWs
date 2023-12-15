package com.mx.Empresa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Empleado {
	private int id;
	private String nombre;
	private String puesto;
	private int empresaId;
}
