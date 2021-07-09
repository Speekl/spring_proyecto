package com.init.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.api.modelo.Empleado;
import com.init.api.modelo.Pago;


@Repository
public interface PagoRep extends JpaRepository<Pago, Long>{

	public List<Pago> findByEmpleado(Empleado empleado);
}
