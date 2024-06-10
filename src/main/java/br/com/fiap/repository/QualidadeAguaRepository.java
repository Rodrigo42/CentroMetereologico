package br.com.fiap.repository;

import br.com.fiap.model.SensorQualidadeAgua;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualidadeAguaRepository extends JpaRepository<SensorQualidadeAgua, Long> {
}
