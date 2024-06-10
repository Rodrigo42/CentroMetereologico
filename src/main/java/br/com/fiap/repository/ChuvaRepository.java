package br.com.fiap.repository;

import br.com.fiap.model.SensorChuva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChuvaRepository extends JpaRepository<SensorChuva, Long> {

}
