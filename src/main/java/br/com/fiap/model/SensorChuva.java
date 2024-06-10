package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_sensor_chuva")
public class SensorChuva {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_CHUVA"
    )
    @SequenceGenerator(
        name = "SQ_CHUVA",
        sequenceName = "SQ_CHUVA",
        allocationSize = 1
    )
    private Long id;
    private Long precipitacao;
    private LocalDate data;
    private Long cto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(Long precipitacao) {
        this.precipitacao = precipitacao;
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
