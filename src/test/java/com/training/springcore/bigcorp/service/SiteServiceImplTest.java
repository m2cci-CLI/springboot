package com.training.springcore.bigcorp.service;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import service.CaptorService;
import service.SiteService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={SiteServiceImplTest.SiteServiceTestConfiguration.class})
public class SiteServiceImplTest {

    @Configuration
    @ComponentScan("com.training.springcore.service")
    static class SiteServiceTestConfiguration{

    }

    @Autowired
    private SiteService siteService;

    @Rule
    public OutputCapture output = new OutputCapture();

    @Mock
    private CaptorService captorService;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void readFileFromUrl(){
        siteService.readFile("url:https://dev-mind.fr/lorem.txt");
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }

    @Test
    public void readFilFromClassath(){
        siteService.readFile("classpath:lorem.txt");
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }

    @Test
    public void readFileFromFileSystem(){
        siteService.readFile("file:/Users/Diginamic/Documents/Exercice_Swing/formation-spring-tp/lorem.txt");
//        siteService.readFile("file:///C:/Users/Diginamic/Documents/Exercice_Swing/formation-spring-tp/src/main/resources/lorem.txt");
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }


}