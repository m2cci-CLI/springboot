package com.training.springcore.bigcorp.service;

import com.training.springcore.bigcorp.epository.CaptorDao;
import com.training.springcore.bigcorp.model.Captor;
import com.training.springcore.bigcorp.model.Site;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Set;

public class CaptorServiceTest {
    @Mock
    private CaptorDao captorDao;
    @InjectMocks
    private CaptorServiceImpl captorService;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void findBySiteShouldReturnNullWhenIdIsNull() {
// Initialisation
        String siteId = null;
// Appel du SUT
        Set<Captor> captors = captorService.findBySite(siteId);
// Vérification
        Assertions.assertThat(captors).isEmpty();
    }
    @Test
    public void findBySite() {
// Initialisation
        String siteId = "siteId";
        Captor expectedCaptor = new Captor("Capteur A", new Site("Florange"));
        Mockito.when(captorDao.findBySiteId(siteId)).thenReturn(Arrays.asList(expectedCaptor))
        ;
// Appel du SUT
        Set<Captor> captors = captorService.findBySite(siteId);
// Vérification
        Assertions.assertThat(captors).hasSize(1);
        Assertions.assertThat(captors).extracting(Captor::getName).contains("Capteur A");
    }
}