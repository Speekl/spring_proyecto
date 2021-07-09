package com.init.api.servicio;

import java.util.List;

import com.init.api.modelo.Empleado;
import com.init.api.modelo.Pago;



public interface IPago {

	public List<Pago> ListAllPago();
	public Pago getPago(Long id);
	public Pago createPago(Pago pago);
	public Pago updatePago(Pago pago);
	public void deletePago(Long id);
	public List<Pago> findByEmpleado(Empleado empleado);
}
