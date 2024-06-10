package br.com.fiap.repository;

import br.com.fiap.model.SensorTerremoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerremotoRepository extends JpaRepository<SensorTerremoto, Long> {
}
