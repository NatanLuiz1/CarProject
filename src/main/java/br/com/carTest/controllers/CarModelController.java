package br.com.carTest.controllers;

import br.com.carTest.dtos.BrandRecordDto;
import br.com.carTest.dtos.CarModelRecordDto;
import br.com.carTest.models.Brand;
import br.com.carTest.models.CarModel;
import br.com.carTest.services.CarModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarModelController {

    @Autowired
    CarModelService carModelService;

    @PostMapping("/models")
    public ResponseEntity<?> createCarModel(@RequestBody @Valid CarModelRecordDto carModelRecordDto){
        return carModelService.createCarModel(carModelRecordDto);
    }
    @GetMapping("/models")
    public ResponseEntity<List<CarModel>> getAllCarModels(){
        return carModelService.getAllCarModels();
    }

    @GetMapping("/models/{id}")
    public ResponseEntity<Object> getCarModelsById(@PathVariable(value="id") Long id){
        return carModelService.getCarModelsById(id);
    }
    @PutMapping("/models/{id}")
    public ResponseEntity<?> updateCarModel(@PathVariable(value="id") Long id,
                                              @RequestBody @Valid CarModelRecordDto carModelRecordDto){
        return carModelService.updateCarModel(id,carModelRecordDto);
    }
    @DeleteMapping("/models/{id}")
    public ResponseEntity<Object> deleteCarModel(@PathVariable(value="id") Long id){
        return carModelService.deleteCarModel(id);
    }
}
