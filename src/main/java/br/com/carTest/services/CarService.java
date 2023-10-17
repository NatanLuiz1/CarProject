package br.com.carTest.services;

import br.com.carTest.dtos.CarRecordDto;
import br.com.carTest.models.Car;
import br.com.carTest.models.CarModel;
import br.com.carTest.repositories.CarModelRepository;
import br.com.carTest.repositories.CarRepository;
import br.com.carTest.util.ErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;
    @Autowired
    CarModelRepository carModelRepository;

    public ResponseEntity<?> createCar(@Valid CarRecordDto carRecordDto){

        Long carModelId = carRecordDto.carModel();
        Optional<CarModel> carModelOptional = carModelRepository.findById(carModelId);

        if(carModelOptional.isEmpty()){
            ErrorResponse error = new ErrorResponse("O Id do modelo inserido não foi encontrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        var car = new Car();
        BeanUtils.copyProperties(carRecordDto, car);
        car.setCarModel(carModelOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(carRepository.save(car));
    }
    public ResponseEntity<List<Car>> getAllCar(){
        return ResponseEntity.status(HttpStatus.OK).body(carRepository.findAll());
    }
    public ResponseEntity<Object> getCarById(@PathVariable(value="id") Long id){
        Optional<Car> car0 = carRepository.findById(id);
        if(car0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(car0.get());
    }
    public ResponseEntity<?> updateCar(@PathVariable(value="id") Long id,
                                            @RequestBody @Valid CarRecordDto carRecordDto){
        Optional<Car> car0 = carRepository.findById(id);
        if(car0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }
        Long carModelId = carRecordDto.carModel();
        Optional<CarModel> carModelOptional = carModelRepository.findById(carModelId);
        if(carModelOptional.isEmpty()){
            ErrorResponse error = new ErrorResponse("O Id do modelo inserido não foi encontrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        var car = car0.get();
        BeanUtils.copyProperties(carRecordDto, car);
        return ResponseEntity.status(HttpStatus.OK).body(carRepository.save(car));
    }
    public ResponseEntity<Object> deleteCar(@PathVariable(value="id") Long id){
        Optional<Car> car0 = carRepository.findById(id);
        if(car0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }
        carRepository.delete(car0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Car deleted sucessfully");
    }

}
