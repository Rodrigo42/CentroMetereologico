package br.com.fiap.repository;

import br.com.fiap.model.SensorSeca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecaRepository extends JpaRepository<SensorSeca, Long> {
}
