package com.init.api.servicio;

import java.util.List;

import com.init.api.modelo.DetDeuda;
import com.init.api.modelo.Deuda;



public interface IDetDeuda {

	public List<DetDeuda> ListAllDetDeuda();
	public DetDeuda getDetDeuda(Long id);
	public DetDeuda createDetDeuda(DetDeuda detalle);
	public DetDeuda updateDetDeuda(DetDeuda detalle);
	public void deleteDetDeuda(Long id);
	public List<DetDeuda> findByDeuda(Deuda deuda);
}
