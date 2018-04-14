package com.learning.appliancestore.repository;

import com.learning.appliancestore.entity.SalesPerDay;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ivanov on 14.4.2018 г..
 */
public interface SalesPerDayRepository extends JpaRepository<SalesPerDay, Integer> {
}
