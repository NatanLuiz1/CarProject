package br.com.carTest.services;

import br.com.carTest.dtos.BrandRecordDto;
import br.com.carTest.models.Brand;
import br.com.carTest.repositories.BrandRepository;
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
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public ResponseEntity<Brand> saveBrand(@Valid BrandRecordDto brandRecordDto){
        var brand = new Brand();
        BeanUtils.copyProperties(brandRecordDto, brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(brandRepository.save(brand));
    }
    public ResponseEntity<List<Brand>> getAllBrands(){
        return ResponseEntity.status(HttpStatus.OK).body(brandRepository.findAll());
    }
    public ResponseEntity<Object> getBrandsById(@PathVariable(value="id") Long id){
        Optional<Brand> brand0 = brandRepository.findById(id);
        if(brand0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Brand not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(brand0.get());
    }
    public ResponseEntity<Object> updateBrand(@PathVariable(value="id") Long id,
                                              @RequestBody @Valid BrandRecordDto brandRecordDto){
        Optional<Brand> brand0 = brandRepository.findById(id);
        if(brand0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Brand not found");
        }
        var brand = brand0.get();
        BeanUtils.copyProperties(brandRecordDto, brand);
        return ResponseEntity.status(HttpStatus.OK).body(brandRepository.save(brand));
    }
    public ResponseEntity<Object> deleteBrand(@PathVariable(value="id") Long id){
        Optional<Brand> brand0 = brandRepository.findById(id);
        if(brand0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Brand not found");
        }
        brandRepository.delete(brand0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Brand deleted sucessfully");
    }
}
