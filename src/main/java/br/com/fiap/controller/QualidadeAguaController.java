package br.com.fiap.controller;

import br.com.fiap.model.SensorQualidadeAgua;
import br.com.fiap.service.QualidadeAguaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qldagua")
public class QualidadeAguaController {


    @Autowired
    private QualidadeAguaService qualidadeAguaService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public Page<SensorQualidadeAgua> listarTodosRegistrosAgua(Pageable pageable){
        return qualidadeAguaService.listarTodosRegistros(pageable);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SensorQualidadeAgua gravar(@RequestBody SensorQualidadeAgua sensorQualidadeAgua){
        return qualidadeAguaService.gravar(sensorQualidadeAgua);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        qualidadeAguaService.excluir(id);
    }

    @PutMapping("/put")
    @ResponseStatus(HttpStatus.OK)
    public SensorQualidadeAgua atualizar(@RequestBody SensorQualidadeAgua sensorQualidadeAgua){
        return qualidadeAguaService.atualizar(sensorQualidadeAgua);
    }

}
