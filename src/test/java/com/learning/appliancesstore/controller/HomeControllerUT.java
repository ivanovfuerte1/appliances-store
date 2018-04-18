package com.learning.appliancesstore.controller;

import com.learning.appliancestore.controller.HomeController;
import com.learning.appliancestore.repository.ApplianceRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivanov on 16.4.2018 г..
 */
public class HomeControllerUT extends BaseUT{
    @InjectMocks
    private HomeController homeController;

    @Mock
    private ModelImpl model;

    @Mock
    private ApplianceRepository applianceRepository;

    @Test
    public void accessDeniedTest(){
        Mockito.when(model.addAttribute("view", "error/403")).thenCallRealMethod();
        Mockito.when(model.containsAttribute("view")).thenCallRealMethod();
        String result = homeController.accessDenied(model);
        Assert.assertTrue(model.containsAttribute("view"));
        Assert.assertEquals("base-layout", result);
    }

    @Test
    public void indexTest(){
        //given
        Mockito.when(applianceRepository.findAll()).thenReturn(new ArrayList<>());
        //when
        String result = homeController.index(model);
        //then
        Assert.assertEquals("base-layout", result);
    }

    private class ModelImpl implements Model {

        private Map<String, Object> attributes;

        @Override
        public Model addAttribute(String s, Object o) {
            if (attributes == null) {
                attributes = new HashMap<>();
            }
            attributes.put(s, o);
            return this;
        }

        @Override
        public Model addAttribute(Object o) {
            return null;
        }

        @Override
        public Model addAllAttributes(Collection<?> collection) {
            return null;
        }

        @Override
        public Model addAllAttributes(Map<String, ?> map) {
            return null;
        }

        @Override
        public Model mergeAttributes(Map<String, ?> map) {
            return null;
        }

        @Override
        public boolean containsAttribute(String s) {
            return attributes.containsKey(s);
        }

        @Override
        public Map<String, Object> asMap() {
            return null;
        }
    }
}
