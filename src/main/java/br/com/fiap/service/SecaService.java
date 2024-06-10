package br.com.fiap.service;


import br.com.fiap.model.SensorSeca;
import br.com.fiap.repository.SecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SecaService {

    @Autowired
    private SecaRepository secaRepository;

    public SensorSeca gravar(SensorSeca sensorSeca){
        if(sensorSeca.getData() == null){
            sensorSeca.setData(LocalDate.now());
        }

        return secaRepository.save(sensorSeca);
    }

    public SensorSeca buscarPorId(Long id){
        Optional<SensorSeca> sensorSecaOptional = secaRepository.findById(id);

        if(sensorSecaOptional.isPresent()){
            return sensorSecaOptional.get();
        }else {
            throw new RuntimeException("Registros no sensor de seca, não encontrados.");
        }
    }

    public Page<SensorSeca> listarTodosRegistros(Pageable pageable){

        return secaRepository.findAll(pageable);
    }

    public void excluir(Long id){
        Optional<SensorSeca> sensorSecaOptional = secaRepository.findById(id);

        if (sensorSecaOptional.isPresent()){
            secaRepository.delete(sensorSecaOptional.get());
        }else {
            throw new RuntimeException("Registro no sensor de seca, não encontrado.");
        }
    }

    public SensorSeca atualizar(SensorSeca sensorSeca){
        Optional<SensorSeca> sensorSecaOptional = secaRepository.findById(sensorSeca.getId());

        if (sensorSecaOptional.isPresent()){

            return secaRepository.save(sensorSeca);
        }else {
            throw new RuntimeException("Registro no sensor de seca, não encontrado.");
        }
    }
}
