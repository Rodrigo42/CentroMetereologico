package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_sensor_qualidade_ar")
public class SensorQualidadeAr {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_QUALIDADE_AR"
    )
    @SequenceGenerator(
            name = "SQ_QUALIDADE_AR",
            sequenceName = "SQ_QUALIDADE_AR",
            allocationSize = 1
    )
    private Long id;
    private Long ar;
    private LocalDate data;
    private Long cto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAr() {
        return ar;
    }

    public void setAr(Long ar) {
        this.ar = ar;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getCto() {
        return cto;
    }

    public void setCto(Long cto) {
        this.cto = cto;
    }
}
