package com.learning.appliancestore.repository;

import com.learning.appliancestore.entity.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ivanov on 7.4.2018 г..
 */
public interface ApplianceRepository extends JpaRepository<Appliance, Integer>{
}
