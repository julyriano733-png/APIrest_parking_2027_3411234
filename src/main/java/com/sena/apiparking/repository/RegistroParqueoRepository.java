package com.sena.apiparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.apiparking.model.RegistroParqueo;

public interface RegistroParqueoRepository extends JpaRepository<RegistroParqueo, Long> {
	

}
