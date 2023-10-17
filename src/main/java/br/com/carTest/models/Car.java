package br.com.carTest.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCar;
    @Column(name = "creation_timestamp")
    private LocalDateTime creationTimestamp;
    private Integer year;
    private String fuelType;
    private Integer portsNumber;
    private String carCollor;
    @ManyToOne
    @JoinColumn(name = "id_model")
    private CarModel carModel;

    @PrePersist
    public void setCreationTimestamp() {
        this.creationTimestamp = LocalDateTime.now();
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getPortsNumber() {
        return portsNumber;
    }

    public void setPortsNumber(Integer portsNumber) {
        this.portsNumber = portsNumber;
    }

    public String getCarCollor() {
        return carCollor;
    }

    public void setCarCollor(String carCollor) {
        this.carCollor = carCollor;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }
}
