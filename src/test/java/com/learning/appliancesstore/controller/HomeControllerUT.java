package com.learning.appliancesstore.controller;

import com.learning.appliancestore.controller.HomeController;
import com.learning.appliancestore.entity.Appliance;
import com.learning.appliancestore.repository.ApplianceRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by ivanov on 16.4.2018 г..
 */
public class HomeControllerUT extends BaseUT {
    @InjectMocks
    private HomeController homeController;

    @Mock
    private ModelImpl modelImpl;

    @Mock
    private Model model;

    @Mock
    private ApplianceRepository applianceRepository;

    @Test
    public void listAppliancesTest() {
        //given
        ArgumentCaptor<Object> argumentCaptor1 = ArgumentCaptor.forClass(Object.class);

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);

        Integer applianceId = 1;
        Set<Integer> applianceIdList = new HashSet<>();
        applianceIdList.add(applianceId);
        Mockito.when(session.getAttribute("selectedAppliances")).thenReturn(applianceIdList);

        Appliance appliance = Mockito.mock(Appliance.class);
        Mockito.when(appliance.getImagePath()).thenReturn("/somePath");
        Optional<Appliance> optionalAppliance = Optional.of(appliance);
        Mockito.when(applianceRepository.findById(applianceId)).thenReturn(optionalAppliance);
        //when
        homeController.listAppliances(model, request);
        //then
        Mockito.verify(model).addAttribute(Mockito.eq("view"), argumentCaptor1.capture());
        Mockito.verify(model).addAttribute(Mockito.eq("appliancePaths"), argumentCaptor1.capture());
        List<Object> allValues = argumentCaptor1.getAllValues();
        String actualView = allValues.get(0).toString();
        Set<String> actualAppliancePath = (Set<String>)allValues.get(1);
        Assert.assertEquals("/basket/show", actualView);
        Assert.assertTrue(actualAppliancePath.contains("/somePath"));
    }

    @Test
    public void accessDeniedTest() {
        Mockito.when(modelImpl.addAttribute("view", "error/403")).thenCallRealMethod();
        Mockito.when(modelImpl.containsAttribute("view")).thenCallRealMethod();
        String result = homeController.accessDenied(modelImpl);
        Assert.assertTrue(modelImpl.containsAttribute("view"));
        Assert.assertEquals("base-layout", result);
    }

    @Test
    public void indexTest() {
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
