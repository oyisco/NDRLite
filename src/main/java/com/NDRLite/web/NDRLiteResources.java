package com.NDRLite.web;

import com.NDRLite.domain.DataVlues;
import com.NDRLite.domain.Facility;
import com.NDRLite.domain.Subcategories;
import com.NDRLite.domain.exception.ResourceException;
import com.NDRLite.domain.repositories.FacilityRepository;
import com.NDRLite.domain.repositories.MonthlyPmctRepository;
import com.NDRLite.domain.repositories.SubCategoriesRepository;
import com.NDRLite.request.MonthlyPmct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pmct")
@RequiredArgsConstructor
@Api(value = "NDRLite", description = "NDR Management")
public class NDRLiteResources {
    private final MonthlyPmctRepository monthlyPmctRepository;
    private final FacilityRepository facilityRepository;
    private final SubCategoriesRepository subCategoriesRepository;

    @PostMapping
    @ApiOperation("Save Monthly PMCT")
    public ResponseEntity<List<MonthlyPmct>> createMonthlyPMCT(@RequestBody List<MonthlyPmct> monthlyPmcts, @RequestHeader("Authorization") String Authorization) {
        monthlyPmcts = monthlyPmcts.stream().peek(monthlyPmct -> {
            try {
                this.monthlyPmctRepository.save(convertServiceEntityToServiceResponse(monthlyPmct));
            } catch (ResourceException e) {
                e.printStackTrace();
            }
        }).collect(Collectors.toList());
        return ResponseEntity.ok(monthlyPmcts);

    }

    @GetMapping
    @ApiOperation("Get Monthly PMCT")
    public ResponseEntity<List<MonthlyPmct>> getMonthlyPmct(@RequestHeader("Authorization") String Authorization) {
        List<DataVlues> dataVlues = this.monthlyPmctRepository.findAll();
        final List<MonthlyPmct>[] monthlyPmctList = new List[]{new ArrayList<>()};
        dataVlues.forEach(dataVlues1 -> {
            monthlyPmctList[0] = this.convertEntityToResponse(dataVlues1);
        });
        return ResponseEntity.ok(monthlyPmctList[0]);
    }

    @GetMapping("/single")
    @ApiOperation("Get Single Monthly PMCT")
    public ResponseEntity<MonthlyPmct> getSingle(@PathVariable Long id) throws ResourceException {
        DataVlues dataVlues = this.monthlyPmctRepository.findById(id).orElseThrow(() -> new ResourceException("PMCT Id Not found: " + id));
        MonthlyPmct monthlyPmct = this.convertEntityToResponse1(dataVlues);
        return ResponseEntity.ok(monthlyPmct);
    }

    private DataVlues convertServiceEntityToServiceResponse(MonthlyPmct monthlyPmct) throws ResourceException {
        Facility facility = this.facilityRepository.findById(monthlyPmct.getFacilityId())
                .orElseThrow(() -> new ResourceException("Facility Id Not found: " + monthlyPmct.getFacilityId()));
        Subcategories subcategories = this.subCategoriesRepository.findById(monthlyPmct.getSubcategoriesId())
                .orElseThrow(() -> new ResourceException("Facility Id Not found: " + monthlyPmct.getFacilityId()));
        return DataVlues.builder()
                .facility(facility)
                .subcategories(subcategories)
                .spokeId(monthlyPmct.getSpokeId())
                .build();
    }

    private List<MonthlyPmct> convertEntityToResponse(DataVlues dataVlues) {
        return Collections.singletonList(MonthlyPmct.builder()
                .facilityId(dataVlues.getFacility().getId())
                .spokeId(dataVlues.getSpokeId())
                .subcategoriesId(dataVlues.getSubcategories().getId())
                .moduleId(dataVlues.getSubcategories().getCategories().getModule().getId())
                .categoryId(dataVlues.getSubcategories().getCategories().getId())
                .period(dataVlues.getPeriod())
                .periodType(dataVlues.getPeriodType())
                .disaggrregation(dataVlues.getDisaggrregation())
                .Value(dataVlues.getValue())
                .build());
    }

    private MonthlyPmct convertEntityToResponse1(DataVlues dataVlues) {
        return MonthlyPmct.builder()
                .facilityId(dataVlues.getFacility().getId())
                .spokeId(dataVlues.getSpokeId())
                .subcategoriesId(dataVlues.getSubcategories().getId())
                .moduleId(dataVlues.getSubcategories().getCategories().getModule().getId())
                .categoryId(dataVlues.getSubcategories().getCategories().getId())
                .period(dataVlues.getPeriod())
                .periodType(dataVlues.getPeriodType())
                .disaggrregation(dataVlues.getDisaggrregation())
                .Value(dataVlues.getValue())
                .build();
    }

}
