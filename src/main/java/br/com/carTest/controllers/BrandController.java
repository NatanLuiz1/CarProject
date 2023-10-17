package br.com.carTest.controllers;

import br.com.carTest.dtos.BrandRecordDto;
import br.com.carTest.models.Brand;
import br.com.carTest.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    BrandService brandService;

    @PostMapping("/brands")
    public ResponseEntity<Brand> createBrand(@RequestBody @Valid BrandRecordDto brandRecordDto){
        return brandService.saveBrand(brandRecordDto);
    }
    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> getAllBrands(){
        return brandService.getAllBrands();
    }
    @GetMapping("/brands/{id}")
    public ResponseEntity<Object> getBrandsById(@PathVariable(value="id") Long id){
        return brandService.getBrandsById(id);
    }
    @PutMapping("/brands/{id}")
    public ResponseEntity<Object> updateBrand(@PathVariable(value="id") Long id,
                                                @RequestBody @Valid BrandRecordDto brandRecordDto){
        return brandService.updateBrand(id,brandRecordDto);
    }
    @DeleteMapping("/brands/{id}")
    public ResponseEntity<Object> deleteBrand(@PathVariable(value="id") Long id){
        return brandService.deleteBrand(id);
    }
}
