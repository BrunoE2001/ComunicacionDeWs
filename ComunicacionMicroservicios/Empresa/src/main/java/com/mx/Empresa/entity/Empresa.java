package com.mx.Empresa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPRESA")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Empresa {
	@Id
	private int id;
	private String nombre;
	private String estado;
}
