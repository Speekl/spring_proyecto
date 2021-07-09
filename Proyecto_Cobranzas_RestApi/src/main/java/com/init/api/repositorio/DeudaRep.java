package com.init.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.api.modelo.Deuda;

@Repository
public interface DeudaRep extends JpaRepository<Deuda, Long> {

}
