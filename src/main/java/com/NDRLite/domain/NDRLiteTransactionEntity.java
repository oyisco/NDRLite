package com.NDRLite.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class  NDRLiteTransactionEntity {
    private LocalDate dCreated;
    private LocalDate createdBy;

}
