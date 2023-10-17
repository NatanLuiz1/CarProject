package br.com.carTest.dtos;

import br.com.carTest.models.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CarModelRecordDto(@NotBlank String modelName, @NotNull BigDecimal carValue,
                                @NotNull Long brand) {
}
