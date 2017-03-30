package ro.licenta.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.licenta.domain.Training;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Cosmin on 26-Mar-17.
 */
@Repository
@Transactional
public class TrainingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Training training) {
        entityManager.persist(training);
    }

    public void update(Training training) {
        entityManager.merge(training);
    }

    @SuppressWarnings("unchecked")
    public List getAll() {
        return entityManager.createQuery("from Training").getResultList();
    }
}
