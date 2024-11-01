package model;

import com.google.gson.annotations.Expose;
import lombok.Data;



@Data
public class SensorChuvaModel {
    @Expose
    private Long id;
    @Expose
    private Long precipitacao;
    @Expose
    private String data;
    @Expose
    private Long cto;
}
