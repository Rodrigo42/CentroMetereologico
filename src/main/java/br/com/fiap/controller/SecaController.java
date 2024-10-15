package br.com.fiap.controller;


import br.com.fiap.model.SensorSeca;
import br.com.fiap.service.SecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/seca")
public class SecaController {

    @Autowired
    private SecaService secaService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public Page<SensorSeca> listarTodosRegistrosSeca(Pageable pageable){
        return secaService.listarTodosRegistros(pageable);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SensorSeca gravar(@RequestBody SensorSeca sensorSeca){
        return secaService.gravar(sensorSeca);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        secaService.excluir(id);
    }

    @PutMapping("/put")
    @ResponseStatus(HttpStatus.OK)
    public SensorSeca atualizar(SensorSeca sensorSeca){
        return secaService.atualizar(sensorSeca);
    }

}
