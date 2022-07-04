package com.NDRLite.domain;

import com.NDRLite.request.Disaggrregation;
import com.NDRLite.request.PeriodType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@Table(name = "data_value")
public class DataVlues extends NDRLiteTransactionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "FACILITY_ID")
    private Facility facility;
    @Column(name = "SPOKE_ID")
    private Integer spokeId;
    @ManyToOne
    @JoinColumn(name = "SUB_CATEGORIES_ID")

    private Subcategories subcategories;
    @Column(name = "period")
    private LocalDate period;

    @Enumerated(EnumType.STRING)
    @Column(name = "disaggrregation")
    private Disaggrregation disaggrregation;

    @Enumerated(EnumType.STRING)
    @Column(name = "period_type")
    private PeriodType periodType;
    @Column(name = "value")
    private Float Value;

    public boolean isNew() {
        return id == null;
    }

}
