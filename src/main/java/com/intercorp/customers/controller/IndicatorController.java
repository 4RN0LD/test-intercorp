package com.intercorp.customers.controller;

import com.intercorp.customers.dto.IndicatorDTO;
import com.intercorp.customers.service.IIndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/indicators")
public class IndicatorController {

    @Autowired
    private IIndicatorService indicatorService;

    @GetMapping
    public ResponseEntity<IndicatorDTO> getIndicators() {
        IndicatorDTO indicator = indicatorService.getIndicators();
        return new ResponseEntity<>(indicator, HttpStatus.OK);
    }

}
