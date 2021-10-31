package com.intercorp.customers.dto;

import lombok.Data;

import java.util.List;

@Data
public class IndicatorDTO {

    private List<QuantityByMonthDTO> quantityByMonths;
    private QuantityByMonthDTO maximum;
    private QuantityByMonthDTO minimum;
    private List<QuantityByMonthDTO> birthRate;

}
