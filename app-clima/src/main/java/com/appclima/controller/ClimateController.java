package com.appclima.controller;

import com.appclima.dto.BasedResponseDTO;
import com.appclima.dto.CityDTO;
import com.appclima.dto.WeatherResponseDTO;
import com.appclima.entity.CityEntity;
import com.appclima.external.response.WeatherResponse;
import com.appclima.service.ClimateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "climate")
@RestController
public class ClimateController {

    @Autowired
    private ClimateService climateService;

    @GetMapping
    @ApiOperation(value = "Retorna o clima e as informações gerais de todas as cidades cadastradas.")
    public ResponseEntity<?> showCities() {
        try {
            List<WeatherResponse> responses = climateService.showCities();
            return ResponseEntity.ok(new WeatherResponseDTO("Chamada realizada com sucesso.", true, responses));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new WeatherResponseDTO("Erro no servidor.", false, null));
        }
    }
}
