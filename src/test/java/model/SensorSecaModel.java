package br.com.fiap.test.model;

import com.google.gson.annotations.Expose;
import lombok.Data;



@Data
public class SensorSecaModel {
    @Expose
    private Long id;
    @Expose
    private Long umidade;
    @Expose
    private String data;
    @Expose
    private Long cto;

}
