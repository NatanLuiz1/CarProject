package br.com.carTest.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "models")
public class CarModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idModel;
    @Column(name = "name")
    private String modelName;
    @Column(name = "valor_fipe")
    private BigDecimal carValue;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    public Long getIdModel() {
        return idModel;
    }

    public void setIdModel(Long idModel) {
        this.idModel = idModel;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public BigDecimal getCarValue() {
        return carValue;
    }

    public void setCarValue(BigDecimal carValue) {
        this.carValue = carValue;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
