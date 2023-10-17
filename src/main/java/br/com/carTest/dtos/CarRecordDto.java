package br.com.carTest.dtos;

public record CarRecordDto(Integer year, String fuelType, Integer portsNumber, String carCollor,
                            Long carModel) {
}
