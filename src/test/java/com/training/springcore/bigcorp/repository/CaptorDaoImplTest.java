package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Captor;

import com.training.springcore.bigcorp.model.PowerSource;
import com.training.springcore.bigcorp.model.Site;
import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import java.util.List;
@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
public class CaptorDaoImplTest {

    @Autowired
    private CaptorDao captorDao;


    private Site site=new Site();


    @Test
    public void findById() {
        Captor captor = captorDao.findById("c1");
        Assertions.assertThat(captor.getId()).isEqualTo("c1");
        Assertions.assertThat(captor.getName()).isEqualTo("Eolienne");

    }
    @Test
    public void findByIdShouldReturnNullWhenIdUnknown() {
        Captor captor = captorDao.findById("c111");
        Assertions.assertThat(captor).isNull();
    }
    @Test
    public void findAll() {
        List<Captor> captors = captorDao.findAll();
        Assertions.assertThat(captors).hasSize(2);
    }


    @Test
    public void update() {
        Captor captor = captorDao.findById("c1");
        Assertions.assertThat(captor.getDefaultPowerInWatt()).isEqualTo(null);
        captor.setDefaultPowerInWatt(2);}



    @Autowired
    private EntityManager entityManager;
    @Test
    public void deleteByIdShouldThrowExceptionWhenIdIsUsedAsForeignKey() {
        Captor captor = captorDao.findById("c1");
        Assertions
                .assertThatThrownBy(() -> {
                    captorDao.delete(captor);
                    entityManager.flush();
                })
                .isExactlyInstanceOf(PersistenceException.class)
                .hasCauseExactlyInstanceOf(ConstraintViolationException.class);
    }


    @Test

    public void create() {
        Site site = new Site("dfghjk");
        entityManager.persist(site);
        Assertions.assertThat(captorDao.findAll()).hasSize(2);
        Captor captor = new Captor("New captor", site);
        captor.setPowerSource(PowerSource.SIMULATED);
        captorDao.persist(captor);
        Assertions.assertThat(captorDao.findAll())
                .hasSize(3)
                .extracting(Captor::getName)
                .contains("Eolienne", "Laminoire a chaud", "New captor");
    }

}
