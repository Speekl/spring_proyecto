package com.init.api.modelo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="detdeuda")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DetDeuda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddeudatalle;
	private Double cantidad;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddeuda")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Deuda deuda;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpago")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Pago pago;

}
