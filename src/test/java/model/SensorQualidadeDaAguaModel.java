package br.com.fiap.test.model;


import com.google.gson.annotations.Expose;
import lombok.Data;



@Data
public class SensorQualidadeDaAguaModel {
    @Expose
    private Long id;
    @Expose
    private Long agua;
    @Expose
    private String data;
    @Expose
    private Long cto;
}
