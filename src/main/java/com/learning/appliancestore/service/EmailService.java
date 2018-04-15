package com.learning.appliancestore.service;

import org.springframework.stereotype.Service;

/**
 * Created by ivanov on 15.4.2018 г..
 */
@Service
public interface EmailService {

    void sendSimpleMessage(
            String to, String subject, String text);
}
