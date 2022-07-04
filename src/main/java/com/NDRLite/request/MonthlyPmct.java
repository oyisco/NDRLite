package com.NDRLite.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MonthlyPmct {
    private Long facilityId;
    private Integer spokeId;
    private Long subcategoriesId;
    private Long moduleId;
    private Long categoryId;
    private Float Value;
    private LocalDate period;
    private PeriodType periodType;
    private Disaggrregation disaggrregation;

}
