package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_sensor_qualidade_agua")
public class SensorQualidadeAgua {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_QUALIDADE_AGUA"
    )
    @SequenceGenerator(
            name = "SQ_QUALIDADE_AGUA",
            sequenceName = "SQ_QUALIDADE_AGUA",
            allocationSize = 1
    )
    private Long id;
    private Long agua;
    private LocalDate data;
    private Long cto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgua() {
        return agua;
    }

    public void setAgua(Long agua) {
        this.agua = agua;
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
