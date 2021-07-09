package com.init.api.modelo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="empleado")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Empleado {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idempleado;
	private String nomempleado;
	private String dni;
	private String telefono;
	private String correo;

}
