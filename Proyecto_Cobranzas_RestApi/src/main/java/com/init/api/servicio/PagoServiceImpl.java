package com.init.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.init.api.modelo.Empleado;
import com.init.api.modelo.Pago;
import com.init.api.repositorio.PagoRep;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements IPago {

	public final PagoRep datapago;
	
	@Override
	public List<Pago> ListAllPago() {
		// TODO Auto-generated method stub
		return datapago.findAll();
	}

	@Override
	public Pago getPago(Long id) {
		// TODO Auto-generated method stub
		return datapago.findById(id).orElse(null);
	}

	@Override
	public Pago createPago(Pago pago) {
		// TODO Auto-generated method stub
		return datapago.save(pago);
	}

	@Override
	public Pago updatePago(Pago pago) {
		Pago pagoUpdate=getPago(pago.getIdpago());
		if(pagoUpdate==null) {
		  return null;
		}
		pagoUpdate.setCantidadrecibida(pago.getCantidadrecibida());
		pagoUpdate.setEmpleado(pago.getEmpleado());
		return datapago.save(pagoUpdate);
	}

	@Override
	public void deletePago(Long id) {
		 datapago.deleteById(id);
	}

	@Override
	public List<Pago> findByEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return datapago.findByEmpleado(empleado);
	}

}
