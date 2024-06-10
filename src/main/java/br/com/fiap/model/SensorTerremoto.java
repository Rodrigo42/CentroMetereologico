package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_sensor_terremoto")
public class SensorTerremoto {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_TERREMOTO"
    )
    @SequenceGenerator(
            name = "SQ_TERREMOTO",
            sequenceName = "SQ_TERREMOTO",
            allocationSize = 1
    )
    private Long id;
    private Long sismico;
    private LocalDate data;
    private Long cto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSismico() {
        return sismico;
    }

    public void setSismico(Long sismico) {
        this.sismico = sismico;
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

    public void setData(LocalDate data) {
        this.data = data;
    }
}
