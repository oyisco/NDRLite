package com.NDRLite.domain.repositories;

import com.NDRLite.domain.DataVlues;
import com.NDRLite.request.MonthlyPmct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyPmctRepository extends JpaRepository<DataVlues, Long> {
}
