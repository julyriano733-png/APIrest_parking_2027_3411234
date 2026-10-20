package com.sena.apiparking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sena.apiparking.model.EspacioParqueo;
import com.sena.apiparking.model.EstadoEspacio;
import com.sena.apiparking.model.TipoVehiculo;

import jakarta.persistence.LockModeType;

public interface EspacioParqueoRepository extends JpaRepository<EspacioParqueo, Long> {
	
@Query("select count(e) > 0 from EpacioParqueo e where e.numero = :numero ")
boolean existexistsByNumero(@Param("numero")Integer numero);
@Lock(LockModeType.PESSIMISTIC_WRITE)
Optional<EspacioParqueo > findFirstByTpioAndEstadoOrderByNumeroAsc(TipoVehiculo tipo, EstadoEspacio estacdo);


@Lock(LockModeType.PESSIMISTIC_WRITE)
@Query("select e from EspacioParqueo e where e.nuemro = :numero ")
Optional<EspacioParqueo> bloquearPorNumero(@Param("numero") Integer numero);



}
