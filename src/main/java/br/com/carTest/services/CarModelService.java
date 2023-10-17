package br.com.carTest.services;

import br.com.carTest.dtos.BrandRecordDto;
import br.com.carTest.dtos.CarModelRecordDto;
import br.com.carTest.models.Brand;
import br.com.carTest.models.CarModel;
import br.com.carTest.repositories.BrandRepository;
import br.com.carTest.repositories.CarModelRepository;
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
public class CarModelService {

    @Autowired
    CarModelRepository carModelRepository;
    @Autowired
    BrandRepository brandRepository;

    public ResponseEntity<?> createCarModel(@Valid CarModelRecordDto carModelRecordDto){

        Long brandId = carModelRecordDto.brand();
        Optional<Brand> brandOptional = brandRepository.findById(brandId);

        if(brandOptional.isEmpty()){
            ErrorResponse error = new ErrorResponse("O Id da marca não foi encontrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        var carModel = new CarModel();
        BeanUtils.copyProperties(carModelRecordDto, carModel);
        carModel.setBrand(brandOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(carModelRepository.save(carModel));
    }
    public ResponseEntity<List<CarModel>> getAllCarModels(){
        return ResponseEntity.status(HttpStatus.OK).body(carModelRepository.findAll());
    }
    public ResponseEntity<Object> getCarModelsById(@PathVariable(value="id") Long id){
        Optional<CarModel> model0 = carModelRepository.findById(id);
        if(model0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Model not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(model0.get());
    }
    public ResponseEntity<?> updateCarModel(@PathVariable(value="id") Long id,
                                              @RequestBody @Valid CarModelRecordDto carModelRecordDto){
        Optional<CarModel> model0 = carModelRepository.findById(id);
        if(model0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Model not found");
        }
        Long brandId = carModelRecordDto.brand();
        Optional<Brand> brandOptional = brandRepository.findById(brandId);
        if(brandOptional.isEmpty()){
            ErrorResponse error = new ErrorResponse("O Id da marca não foi encontrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        var carModel = model0.get();
        BeanUtils.copyProperties(carModelRecordDto, carModel);
        return ResponseEntity.status(HttpStatus.OK).body(carModelRepository.save(carModel));
    }
    public ResponseEntity<Object> deleteCarModel(@PathVariable(value="id") Long id){
        Optional<CarModel> model0 = carModelRepository.findById(id);
        if(model0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Model not found");
        }
        carModelRepository.delete(model0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Model deleted sucessfully");
    }
}
