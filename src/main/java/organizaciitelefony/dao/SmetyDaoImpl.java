package organizaciitelefony.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import organizaciitelefony.model.Smety;

import java.util.List;

@Repository
public class SmetyDaoImpl implements SmetyDao {
    private static final Logger logger = LoggerFactory.getLogger(OrganizaciiDao.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSmeta(Smety smety) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(smety);
        logger.info("Smety succssefully saved. Organization detail:" + smety);
    }

    @Override
    public void updateSmeta(Smety smety) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(smety);
        logger.info("Smety successfully update. Organization detail: " + smety);

    }

    @Override
    public void removeSmeta(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Smety smety = (Smety) session.load(Smety.class, new Integer(id));
        if (smety != null) {
            session.delete(smety);
        }
        logger.info("Smety successfully removed. Smeta detail: " + smety);


    }

    @Override
    public Smety getSmetaById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Smety smety = (Smety) session.load(Smety.class, new Integer(id));
        logger.info("Smety successfully loaded. Smeta detail: " + smety);
        return smety;
    }

    @Override
    public List<Smety> listSmety() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Smety> smetyList = session.createQuery("from Smety").list();
        for (Smety smety : smetyList) {
            logger.info("Smety list:");
        }
        return smetyList;
    }

}
