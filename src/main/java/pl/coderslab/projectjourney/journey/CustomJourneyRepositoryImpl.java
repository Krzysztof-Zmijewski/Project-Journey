package pl.coderslab.projectjourney.journey;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class CustomJourneyRepositoryImpl implements CustomJourneyRepository{
    @PersistenceContext
    EntityManager em;
    @Override
    public void updateJourneyBy(Journey journey) {
        Query q = em.createQuery("UPDATE Journey j set j.title = ?1, j.since = ?2, j.deadline = ?3 where j.id = ?4").setParameter(1, journey.getTitle())
                .setParameter(2, journey.getSince())
                .setParameter(3, journey.getDeadline())
                .setParameter(4, journey.getId());
        q.executeUpdate();
    }
}
