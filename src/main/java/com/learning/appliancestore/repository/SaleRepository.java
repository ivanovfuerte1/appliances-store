package com.learning.appliancestore.repository;

import com.learning.appliancestore.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ivanov on 1.4.2018 г..
 */
public interface SaleRepository extends JpaRepository<Sale, Integer>{
}
