package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SensorQualidadeArModel {
    @Expose
    private Long id;
    @Expose
    private Long ar;
    @Expose
    private String data;
    @Expose
    private Long cto;
}
