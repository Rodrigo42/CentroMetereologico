package br.com.fiap.controller;


import br.com.fiap.model.SensorQualidadeAr;
import br.com.fiap.service.QualidadeArService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qldar")
public class QualidadeArController {
    @Autowired
    private QualidadeArService qualidadeArService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public Page<SensorQualidadeAr> listarTodosRegistrosAr(Pageable pageable){
        return qualidadeArService.listarTodosRegistros(pageable);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SensorQualidadeAr gravar(@RequestBody SensorQualidadeAr sensorQualidadeAr){
        return qualidadeArService.gravar(sensorQualidadeAr);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        qualidadeArService.excluir(id);
    }

    @PutMapping("/put")
    @ResponseStatus(HttpStatus.OK)
    public SensorQualidadeAr atualizar(@RequestBody SensorQualidadeAr sensorQualidadeAr){
        return qualidadeArService.atualizar(sensorQualidadeAr);
    }
}
