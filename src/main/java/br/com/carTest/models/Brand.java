package br.com.carTest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity
@Table(name="brands")
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBrand;
    @NotBlank
    private String brandName;

    public Long getIdBrand() {
        return idBrand;
    }
    public void setIdBrand(Long idBrand) {
        this.idBrand = idBrand;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
