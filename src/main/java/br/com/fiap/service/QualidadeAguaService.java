package br.com.fiap.service;


import br.com.fiap.model.SensorQualidadeAgua;
import br.com.fiap.repository.QualidadeAguaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class QualidadeAguaService {
    @Autowired
    private QualidadeAguaRepository qualidadeAguaRepository;

    public SensorQualidadeAgua gravar(SensorQualidadeAgua sensorQualidadeAgua){

        if(sensorQualidadeAgua.getData() == null){
            sensorQualidadeAgua.setData(LocalDate.now());
        }

        return qualidadeAguaRepository.save(sensorQualidadeAgua);
    }

    public SensorQualidadeAgua buscarPorId(Long id){
        Optional<SensorQualidadeAgua> sensorQualidadeAguaOptional = qualidadeAguaRepository.findById(id);

        if(sensorQualidadeAguaOptional.isPresent()){
            return sensorQualidadeAguaOptional.get();
        }else {
            throw new RuntimeException("Registros no sensor de qualidade da agua não encontrados.");
        }
    }

    public Page<SensorQualidadeAgua> listarTodosRegistros(Pageable pageable){

        return qualidadeAguaRepository.findAll(pageable);
    }

    public void excluir(Long id){
        Optional<SensorQualidadeAgua> sensorQualidadeAguaOptional = qualidadeAguaRepository.findById(id);

        if (sensorQualidadeAguaOptional.isPresent()){
            qualidadeAguaRepository.delete(sensorQualidadeAguaOptional.get());
        }else {
            throw new RuntimeException("Registro no sensor de qualidade da agua não encontrado.");
        }
    }

    public SensorQualidadeAgua atualizar(SensorQualidadeAgua sensorQualidadeAgua){
        Optional<SensorQualidadeAgua> sensorQualidadeAguaOptional = qualidadeAguaRepository.findById(sensorQualidadeAgua.getId());

        if (sensorQualidadeAguaOptional.isPresent()){
            return qualidadeAguaRepository.save(sensorQualidadeAgua);
        }else {
            throw new RuntimeException("Registro no sensor de qualidade da agua não encontrado.");
        }
    }
}
