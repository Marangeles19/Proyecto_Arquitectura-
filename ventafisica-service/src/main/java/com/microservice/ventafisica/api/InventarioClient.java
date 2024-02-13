package com.microservice.ventafisica.api;

import com.microservice.ventafisica.model.dto.StockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventarioClient {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${stock.service.url}")
    private String stockServiceUrl;
    public StockDTO getStock(String nombre) {
        ResponseEntity<StockDTO> response = restTemplate.getForEntity(
                stockServiceUrl + "/producto/" + nombre, StockDTO.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

}
