package br.com.fiap.service;

import br.com.fiap.model.SensorChuva;
import br.com.fiap.repository.ChuvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ChuvaService {

    @Autowired
    private ChuvaRepository chuvaRepository;

    public SensorChuva gravar(SensorChuva sensorChuva){

        if(sensorChuva.getData() == null){
            sensorChuva.setData(LocalDate.now());
        }

        return chuvaRepository.save(sensorChuva);
    }

    public SensorChuva buscarPorId(Long id){
        Optional<SensorChuva> sensorChuvaOptional = chuvaRepository.findById(id);

        if(sensorChuvaOptional.isPresent()){
            return sensorChuvaOptional.get();
        }else {
            throw new RuntimeException("Registros no sensor de chuva, não encontrados.");
        }
    }

    public Page<SensorChuva> listarTodosRegistros(Pageable pageable){

        return chuvaRepository.findAll(pageable);
    }

    public void excluir(Long id){
        Optional<SensorChuva> sensorChuvaOptional = chuvaRepository.findById(id);

        if (sensorChuvaOptional.isPresent()){
            chuvaRepository.delete(sensorChuvaOptional.get());
        }else {
            throw new RuntimeException("Registro no sensor de chuva, não encontrado.");
        }
    }

    public SensorChuva atualizar(SensorChuva sensorChuva){
        Optional<SensorChuva> sensorChuvaOptional = chuvaRepository.findById(sensorChuva.getId());

        if (sensorChuvaOptional.isPresent()){
            return chuvaRepository.save(sensorChuva);
        }else {
            throw new RuntimeException("Registro no sensor de chuva, não encontrado.");
        }
    }
}
