package br.com.fiap.repository;

import br.com.fiap.model.SensorQualidadeAr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualidadeArRepository extends JpaRepository<SensorQualidadeAr, Long> {
}
