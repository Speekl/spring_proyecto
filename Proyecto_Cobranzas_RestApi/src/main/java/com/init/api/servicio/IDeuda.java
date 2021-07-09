package com.init.api.servicio;

import java.util.List;

import com.init.api.modelo.Deuda;

public interface IDeuda {

	public List<Deuda> ListAllDeuda();
	public Deuda getDeuda(Long id);
	public Deuda createDeuda(Deuda deuda);
	public Deuda updateDeuda(Deuda deuda);
	public void deleteDeuda(Long id);
	
}
