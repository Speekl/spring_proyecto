package com.init.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.api.modelo.DetDeuda;
import com.init.api.modelo.Deuda;

@Repository
public interface DetDeudaRep extends JpaRepository<DetDeuda, Long>{
	
	public List<DetDeuda> findByDeuda(Deuda deuda);

}
