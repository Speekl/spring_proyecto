package com.init.api.modelo;


import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="deuda")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Deuda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddeuda;
    private String nombre;
    private String motivo;
}
