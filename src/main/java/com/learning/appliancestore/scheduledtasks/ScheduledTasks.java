package com.learning.appliancestore.scheduledtasks;

import com.learning.appliancestore.entity.SalesPerDay;
import com.learning.appliancestore.repository.SaleRepository;
import com.learning.appliancestore.repository.SalesPerDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ivanov on 14.4.2018 г..
 */
@Component
public class ScheduledTasks {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SalesPerDayRepository salesPerDayRepository;

    @Scheduled(cron = "0 0 22 * * ?")
    public void scheduleTaskUsingCronExpression() {
        int size = saleRepository.findAll().size();
        Date date = new Date();
        System.out.println("The sales up to " + date + " are: " + size);
        SalesPerDay salesPerDay = new SalesPerDay(size, date);
        salesPerDayRepository.saveAndFlush(salesPerDay);
    }
}
