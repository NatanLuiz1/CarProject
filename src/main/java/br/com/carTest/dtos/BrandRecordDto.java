package br.com.carTest.dtos;

import jakarta.validation.constraints.NotBlank;

public record BrandRecordDto(@NotBlank String brandName) {

}
