package com.learning.appliancesstore.controller;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * Created by ivanov on 18.4.2018 г..
 */
public abstract class BaseUT {
    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
}
