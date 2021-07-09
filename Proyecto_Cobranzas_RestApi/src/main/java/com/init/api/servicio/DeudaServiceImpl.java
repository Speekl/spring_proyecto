package com.init.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.init.api.modelo.Deuda;
import com.init.api.repositorio.DeudaRep;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeudaServiceImpl implements IDeuda{

	public final DeudaRep datadeuda;
	
	@Override
	public List<Deuda> ListAllDeuda() {
		// TODO Auto-generated method stub
		return datadeuda.findAll();
	}

	@Override
	public Deuda getDeuda(Long id) {
		// TODO Auto-generated method stub
		return datadeuda.findById(id).orElse(null);
	}

	@Override
	public Deuda createDeuda(Deuda deuda) {
		// TODO Auto-generated method stub
		return datadeuda.save(deuda);
	}

	@Override
	public Deuda updateDeuda(Deuda deuda) {
		Deuda deudaUpdate=getDeuda(deuda.getIddeuda());
		if(deudaUpdate==null) {
		  return null;
		}
		deudaUpdate.setNombre(deuda.getNombre());
		deudaUpdate.setMotivo(deuda.getMotivo());
		return datadeuda.save(deudaUpdate);
	}

	@Override
	public void deleteDeuda(Long id) {
		// TODO Auto-generated method stub
		datadeuda.deleteById(id);
	}

}
