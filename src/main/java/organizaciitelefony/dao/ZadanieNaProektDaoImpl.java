package organizaciitelefony.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import organizaciitelefony.dao.ZadanieNaProektDao;
import organizaciitelefony.model.ZadanieNaProekt;

import java.util.List;
@Repository

public class ZadanieNaProektDaoImpl implements ZadanieNaProektDao {
    private static final Logger logger = LoggerFactory.getLogger(OrganizaciiDao.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addZadanie(ZadanieNaProekt zadanieNaProekt) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(zadanieNaProekt);
        logger.info("ZadanieNaProekt succssefully saved. Organization detail:" + zadanieNaProekt);
    }

    @Override
    public void updateZadanie(ZadanieNaProekt zadanieNaProekt) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(zadanieNaProekt);

    }

    @Override
    public void removeZadanie(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ZadanieNaProekt zadanieNaProekt= (ZadanieNaProekt) session.load(ZadanieNaProekt.class, new Integer(id));
        if (zadanieNaProekt != null) {
            session.delete(zadanieNaProekt);
        }
        logger.info("ZadanieNaProekt successfully removed. ZadanieNaProekt detail: " + zadanieNaProekt);
    }

    @Override
    public ZadanieNaProekt getZadanieById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ZadanieNaProekt zadanieNaProekt = (ZadanieNaProekt) session.load(ZadanieNaProekt.class, new Integer(id));
        return zadanieNaProekt;

    }

    @Override
    public List<ZadanieNaProekt> listZadanie()
    {
        Session session=this.sessionFactory.getCurrentSession();
        List<ZadanieNaProekt> zadanieNaProektList = session.createQuery("from ZadanieNaProekt").list();
        for (ZadanieNaProekt zadanieNaProekt : zadanieNaProektList) {
            logger.info("ZadanieNaProekt list:");
        }
        return zadanieNaProektList;
    }
}
