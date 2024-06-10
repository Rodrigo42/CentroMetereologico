package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_sensor_seca")
public class SensorSeca {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_SECA"
    )
    @SequenceGenerator(
            name = "SQ_SECA",
            sequenceName = "SQ_SECA",
            allocationSize = 1
    )
    private Long id;
    private Long umidade;
    private LocalDate data;
    private Long cto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUmidade() {
        return umidade;
    }

    public void setUmidade(Long umidade) {
        this.umidade = umidade;
    }

    public Long getCto() {
        return cto;
    }

    public void setCto(Long cto) {
        this.cto = cto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate localDate) {
        this.data = localDate;
    }
}
