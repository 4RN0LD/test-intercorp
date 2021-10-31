package com.intercorp.customers.service.impl;

import com.intercorp.customers.dto.IndicatorDTO;
import com.intercorp.customers.dto.QuantityByMonthDTO;
import com.intercorp.customers.repository.CustomerRepo;
import com.intercorp.customers.service.IIndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndicatorServiceImpl implements IIndicatorService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public IndicatorDTO getIndicators() {
        IndicatorDTO indicator = new IndicatorDTO();
        List<QuantityByMonthDTO> quantityByMonths = repo.groupByBirthDate().stream().map(o -> {
            QuantityByMonthDTO quantityByMonth = new QuantityByMonthDTO();
            quantityByMonth.setMonth(o[0].toString());
            quantityByMonth.setQuantity(Double.parseDouble(o[1].toString()));
            return quantityByMonth;
        }).collect(Collectors.toList());
        Double poblacion = quantityByMonths.stream().mapToDouble(QuantityByMonthDTO::getQuantity).sum();
        indicator.setQuantityByMonths(quantityByMonths);
        indicator.setBirthRate(quantityByMonths.stream().map(quantityByMonthDTO -> {
            QuantityByMonthDTO quantityByMonth = new QuantityByMonthDTO();
            quantityByMonth.setMonth(quantityByMonthDTO.getMonth());
            quantityByMonth.setQuantity((quantityByMonthDTO.getQuantity() / poblacion) * 1000);
            return quantityByMonth;
        }).collect(Collectors.toList()));
        if (quantityByMonths.size() > 0) {
            indicator.setMaximum(quantityByMonths.stream().max((quantityByMonthDTO, t1) -> quantityByMonthDTO.getQuantity().compareTo(t1.getQuantity())).get());
            indicator.setMinimum(quantityByMonths.stream().min((quantityByMonthDTO, t1) -> quantityByMonthDTO.getQuantity().compareTo(t1.getQuantity())).get());
        }
        return indicator;
    }
}
