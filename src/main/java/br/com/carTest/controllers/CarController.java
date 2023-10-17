package br.com.carTest.controllers;

import br.com.carTest.dtos.CarRecordDto;
import br.com.carTest.models.Car;
import br.com.carTest.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/cars")
    public ResponseEntity<?> createCar(@RequestBody @Valid CarRecordDto carRecordDto){
        return carService.createCar(carRecordDto);
    }
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCarModels(){
        return carService.getAllCar();
    }
    @GetMapping("/cars/{id}")
    public ResponseEntity<Object> getCarById(@PathVariable(value="id") Long id){
        return carService.getCarById(id);
    }
    @PutMapping("/cars/{id}")
    public ResponseEntity<?> updateCar(@PathVariable(value="id") Long id,
                                            @RequestBody @Valid CarRecordDto carRecordDto){
        return carService.updateCar(id,carRecordDto);
    }
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable(value="id") Long id){
        return carService.deleteCar(id);
    }
}
