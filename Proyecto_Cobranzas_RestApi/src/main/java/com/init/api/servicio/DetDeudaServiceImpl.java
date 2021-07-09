package com.init.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.init.api.modelo.DetDeuda;
import com.init.api.modelo.Deuda;
import com.init.api.repositorio.DetDeudaRep;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetDeudaServiceImpl implements IDetDeuda{

	public final DetDeudaRep datadetalle;
	
	@Override
	public List<DetDeuda> ListAllDetDeuda() {
		// TODO Auto-generated method stub
		return datadetalle.findAll();
	}

	@Override
	public DetDeuda getDetDeuda(Long id) {
		// TODO Auto-generated method stub
		return datadetalle.findById(id).orElse(null);
	}

	@Override
	public DetDeuda createDetDeuda(DetDeuda detalle) {
		// TODO Auto-generated method stub
		return datadetalle.save(detalle);
	}

	@Override
	public DetDeuda updateDetDeuda(DetDeuda detalle) {
		DetDeuda detalleUpdate=getDetDeuda(detalle.getIddeudatalle());
		if(detalleUpdate==null) {
		  return null;
		}
		detalleUpdate.setCantidad(detalle.getCantidad());
		detalleUpdate.setDeuda(detalle.getDeuda());
		detalleUpdate.setPago(detalle.getPago());
		
		return datadetalle.save(detalleUpdate);
	}

	@Override
	public void deleteDetDeuda(Long id) {
		// TODO Auto-generated method stub
		datadetalle.deleteById(id);
	}

	@Override
	public List<DetDeuda> findByDeuda(Deuda deuda) {
		// TODO Auto-generated method stub
		return datadetalle.findByDeuda(deuda);
	}

}
