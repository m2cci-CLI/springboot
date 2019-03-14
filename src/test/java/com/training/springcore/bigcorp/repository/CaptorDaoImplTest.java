package com.training.springcore.bigcorp.repository;
import com.training.springcore.bigcorp.model.*;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
@Transactional
public class CaptorDaoImplTest {

    Captor captor = new RealCaptor("Eolienne", new Site("site1"));

    @Autowired
    private CaptorDao captorDao;
    @Autowired
    private EntityManager entityManager;
    @Test
    public void findById() {
        Optional<Captor> captor = captorDao.findById("c1");
        Assertions.assertThat(captor).get().extracting("name").containsExactly("Eolienne");
    }
    @Test
    public void findByIdShouldReturnNullWhenIdUnknown() {
        Optional<Captor> captor = captorDao.findById("unknown");
        Assertions.assertThat(captor).isEmpty();
    }
    @Test
    public void findAll() {
        List<Captor> sites = captorDao.findAll();
        Assertions.assertThat(sites)
                .hasSize(2)
                .extracting("id", "name")
                .contains(Tuple.tuple("c2", "Laminoire à chaud"));

    }
    @Test
    public void create() {
        Site site = new Site("dfghjk");
        site.setId("site1");
        Assertions.assertThat(captorDao.findAll()).hasSize(2);
        Captor captor = new RealCaptor("New captor", site);
        captor.setSite(site);
        captorDao.save(captor);
        Assertions.assertThat(captorDao.findAll())
                .hasSize(3)
                .extracting(Captor::getName)
                .contains("Eolienne", "Laminoire à chaud", "New captor");
    }





    public void update() {
        Optional<Captor> captor = captorDao.findById("c1");
        Assertions.assertThat(captor).get().extracting("name").containsExactly("Eolienne");
        captor.ifPresent(s -> {
            s.setName("captor updated");
            captorDao.save(s);
        });
        captor = captorDao.findById("c1");
        Assertions.assertThat(captor).get().extracting("name").containsExactly("captor updated");
    }








        @Test
    public void deleteById() {
        Site site = new Site("site1");
        entityManager.persist(site);
        Captor newcaptor = new RealCaptor("Profissionnalcap",site);
        newcaptor = captorDao.save(newcaptor);
        Assertions.assertThat(captorDao.findById(newcaptor.getId())).isNotEmpty();
        captorDao.delete(newcaptor);
        Assertions.assertThat(captorDao.findById(newcaptor.getId())).isEmpty();
    }
    @Test
    public void deleteByIdShouldThrowExceptionWhenIdIsUsedAsForeignKey() {
        Captor captor = captorDao.getOne("c1");
        Assertions
                .assertThatThrownBy(() -> {
                    captorDao.delete(captor);
                    entityManager.flush();
                })
                .isExactlyInstanceOf(PersistenceException.class)
                .hasCauseExactlyInstanceOf(ConstraintViolationException.class);
    }


    @Test
    public void findByExample() {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", match -> match.ignoreCase().contains())
                .withIgnorePaths("id")
                .withIgnorePaths("defaultPowerInWatt")
                .withIgnorePaths("site")
                .withIgnoreNullValues();
       Site site = new Site("Site2");
        entityManager.persist(site);
        Captor captor = new FixedCaptor("lienn", site);
        List<Captor> captors = captorDao.findAll(Example.of(captor, matcher));
        Assertions.assertThat(captors)
                .hasSize(1)
                .extracting("id", "name")
                .containsExactly(Tuple.tuple("c1", "Eolienne"));
    }


    @Test
    public void preventConcurrentWrite() {
        Captor captor = captorDao.getOne("c1");
// A la base le numéro de version est à sa valeur initiale
        Assertions.assertThat(captor.getVersion()).isEqualTo(0);
// On detache cet objet du contexte de persistence
        entityManager.detach(captor);
        captor.setName("Captor updated");
// On force la mise à jour en base (via le flush) et on vérifie que l'objet
// et attaché à la session a été mis à jour
        Captor attachedCaptor = captorDao.save(captor);
        entityManager.flush();
        Assertions.assertThat(attachedCaptor.getName()).isEqualTo("Captor updated");
        Assertions.assertThat(attachedCaptor.getVersion()).isEqualTo(1);
// Si maintenant je réessaie d'enregistrer captor, comme le numéro de version est
// à 0 je dois avoir une exception
        Assertions.assertThatThrownBy(() -> captorDao.save(captor))
                .isExactlyInstanceOf(ObjectOptimisticLockingFailureException.class);
    }






}
