package br.com.fiap.service;


import br.com.fiap.model.SensorQualidadeAr;
import br.com.fiap.repository.QualidadeArRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class QualidadeArService {
    @Autowired
    private QualidadeArRepository qualidadeArRepository;

    public SensorQualidadeAr gravar(SensorQualidadeAr sensorQualidadeAr){

        if(sensorQualidadeAr.getData() == null){
            sensorQualidadeAr.setData(LocalDate.now());
        }

        return qualidadeArRepository.save(sensorQualidadeAr);
    }

    public SensorQualidadeAr buscarPorId(Long id){
        Optional<SensorQualidadeAr> sensorQualidadeArOptional = qualidadeArRepository.findById(id);

        if(sensorQualidadeArOptional.isPresent()){
            return sensorQualidadeArOptional.get();
        }else {
            throw new RuntimeException("Registros no sensor de qualidade do ar não encontrados.");
        }
    }

    public Page<SensorQualidadeAr> listarTodosRegistros(Pageable pageable){

        return qualidadeArRepository.findAll(pageable);
    }

    public void excluir(Long id){
        Optional<SensorQualidadeAr> sensorQualidadeArOptional = qualidadeArRepository.findById(id);

        if (sensorQualidadeArOptional.isPresent()){
            qualidadeArRepository.delete(sensorQualidadeArOptional.get());
        }else {
            throw new RuntimeException("Registro no sensor de qualidade do ar não encontrado.");
        }
    }

    public SensorQualidadeAr atualizar(SensorQualidadeAr sensorQualidadeAr){
        Optional<SensorQualidadeAr> sensorQualidadeArOptional = qualidadeArRepository.findById(sensorQualidadeAr.getId());

        if (sensorQualidadeArOptional.isPresent()){
            return qualidadeArRepository.save(sensorQualidadeAr);
        }else {
            throw new RuntimeException("Registro no sensor de qualidade do ar não encontrado.");
        }
    }
}
