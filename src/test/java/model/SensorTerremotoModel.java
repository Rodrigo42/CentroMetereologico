package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SensorTerremotoModel {
    @Expose
    private Long id;
    @Expose
    private Long sismico;
    @Expose
    private String data;
    @Expose
    private Long cto;
}
