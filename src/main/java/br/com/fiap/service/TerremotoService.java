package br.com.fiap.service;



import br.com.fiap.model.SensorTerremoto;
import br.com.fiap.repository.TerremotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TerremotoService {


    @Autowired
    private TerremotoRepository terremotoRepository;

    public SensorTerremoto gravar(SensorTerremoto sensorTerremoto){

        if(sensorTerremoto.getData() == null){
            sensorTerremoto.setData(LocalDate.now());
        }

        return terremotoRepository.save(sensorTerremoto);
    }

    public SensorTerremoto buscarPorId(Long id){
        Optional<SensorTerremoto> sensorTerremotoOptional = terremotoRepository.findById(id);

        if(sensorTerremotoOptional.isPresent()){
            return sensorTerremotoOptional.get();
        }else {
            throw new RuntimeException("Registros no sensor de terremoto não encontrados.");
        }
    }

    public Page<SensorTerremoto> listarTodosRegistros(Pageable pageable){

        return terremotoRepository.findAll(pageable);
    }

    public void excluir(Long id){
        Optional<SensorTerremoto> sensorTerremotoOptional = terremotoRepository.findById(id);

        if (sensorTerremotoOptional.isPresent()){
            terremotoRepository.delete(sensorTerremotoOptional.get());
        }else {
            throw new RuntimeException("Registro no sensor de terremoto não encontrado.");
        }
    }

    public SensorTerremoto atualizar(SensorTerremoto sensorTerremoto){
        Optional<SensorTerremoto> sensorTerremotoOptional = terremotoRepository.findById(sensorTerremoto.getId());

        if (sensorTerremotoOptional.isPresent()){
            return terremotoRepository.save(sensorTerremoto);
        }else {
            throw new RuntimeException("Registro no sensor de terremoto não encontrado.");
        }
    }
}
