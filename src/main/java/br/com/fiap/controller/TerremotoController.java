package br.com.fiap.controller;


import br.com.fiap.model.SensorTerremoto;
import br.com.fiap.service.TerremotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/terremoto")
public class TerremotoController {

    @Autowired
    private TerremotoService terremotoService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public Page<SensorTerremoto> listarTodosRegistrosTerremoto(Pageable pageable){
        return terremotoService.listarTodosRegistros(pageable);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SensorTerremoto gravar(@RequestBody SensorTerremoto sensorTerremoto){
        return terremotoService.gravar(sensorTerremoto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        terremotoService.excluir(id);
    }

    @PutMapping("/put")
    @ResponseStatus(HttpStatus.OK)
    public SensorTerremoto atualizar(@RequestBody SensorTerremoto sensorTerremoto){
        return terremotoService.atualizar(sensorTerremoto);
    }

}
