package organizaciitelefony.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import organizaciitelefony.model.Dogovor;
import organizaciitelefony.model.Rekvizity;

import java.util.List;

@Repository
public class DogovorDaoImpl implements DogovorDao {
    private static final Logger logger = LoggerFactory.getLogger(OrganizaciiDao.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDogovor(Dogovor dogovor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(dogovor);
        logger.info("Dogovor succssefully saved. Organization detail:" + dogovor);
    }

    @Override
    public void updateDogovor(Dogovor dogovor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(dogovor);
        logger.info("Contracts successfully apdate. Organization detail: " + dogovor);
    }

    @Override
    public void removeDogovor(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Dogovor dogovor = (Dogovor) session.load(Dogovor.class, new Integer(id));
        if (dogovor != null) {
            session.delete(dogovor);
        }
        logger.info("Dogovor successfully removed. Organization detail: " + dogovor);
    }

    @Override
    public Dogovor getDogovorById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Dogovor dogovor = (Dogovor) session.load(Dogovor.class, new Integer(id));
        logger.info("Dogovor successfully loaded. Organization detail: " + dogovor);
        return dogovor;
    }

    @Override
    public List<Dogovor> listDogovor() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Dogovor> dogovorList = session.createQuery("from Dogovor").list();
        for (Dogovor dogovor : dogovorList) {
            logger.info("Organization list:");
        }
        return dogovorList;
    }
}
