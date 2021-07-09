package com.init.api.modelo;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pago")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpago;
    private Double cantidadrecibida;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idempleado")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Empleado empleado;
}
