package organizaciitelefony.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import organizaciitelefony.model.Nzt;

import java.util.List;
@Repository
public class NztDaoImpl implements NztDao {
    private static final Logger logger = LoggerFactory.getLogger(OrganizaciiDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addNzt(Nzt nzt) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(nzt);
        logger.info("NZT succssefully saved. Organization detail:" + nzt);
    }

    @Override
    public void updateNzt(Nzt nzt) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(nzt);
        logger.info("NZT successfully update. Organization detail: " + nzt);
    }

    @Override
    public void removeNzt(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Nzt nzt = (Nzt) session.load(Nzt.class, new Integer(id));
        if (nzt != null) {
            session.delete(nzt);
        }
        logger.info("NZT successfully removed. Organization detail: " + nzt);
    }

    @Override
    public Nzt getNztById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Nzt nzt = (Nzt)session.load(Nzt.class, new Integer(id));
        logger.info("NZt successfully loaded. Organization detail: " + nzt);
        return nzt;
    }

    @Override
    public List<Nzt> listNzt() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Nzt> nztList = session.createQuery("from Nzt").list();
        for (Nzt nzt : nztList) {
            logger.info("Organization list:");
        }
        return nztList;
    }


}
