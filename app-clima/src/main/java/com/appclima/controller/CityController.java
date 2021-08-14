package com.appclima.controller;

import com.appclima.dto.BasedResponseDTO;
import com.appclima.dto.CityDTO;
import com.appclima.entity.CityEntity;
import com.appclima.service.CityService;
import com.appclima.service.ClimateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "city")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    @ApiOperation(value = "Adicionar uma nova cidade")
    public CityEntity addCity(
            @ApiParam(value = "Nome e número único da cidade")
            @RequestBody CityDTO cityDTO) {

        return cityService.addCity(cityDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deletar uma cidade pelo ID.")
    public ResponseEntity<?> deleteCity(
            @ApiParam(value = "Id da cidade")
            @PathVariable Long id) {
        try {
            cityService.deleteCity(id);
            return ResponseEntity.ok(new BasedResponseDTO("Cidade deletada com sucesso.", true));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BasedResponseDTO("Erro no servidor. " + e.getMessage(), false));
        }
    }
}
