package br.com.fiap.controller;

import br.com.fiap.model.SensorChuva;
import br.com.fiap.service.ChuvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chuva")
public class ChuvaController {

    @Autowired
    private ChuvaService chuvaService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public Page<SensorChuva> listarTodosRegistrosChuva(Pageable pageable){
        return chuvaService.listarTodosRegistros(pageable);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SensorChuva gravar(@RequestBody SensorChuva sensorChuva){
        return chuvaService.gravar(sensorChuva);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        chuvaService.excluir(id);
    }

    @PutMapping("/put")
    @ResponseStatus(HttpStatus.OK)
    public SensorChuva atualizar(@RequestBody SensorChuva sensorChuva){
        return chuvaService.atualizar(sensorChuva);
    }
}
