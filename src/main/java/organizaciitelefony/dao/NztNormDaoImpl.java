package organizaciitelefony.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import organizaciitelefony.model.NZTNorm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import organizaciitelefony.model.Nzt;

import java.util.List;

@Repository
public class NztNormDaoImpl implements NztNormDao {
    private static final Logger logger = LoggerFactory.getLogger(OrganizaciiDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addNztNorm(NZTNorm nztNorm) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(nztNorm);
        logger.info("NZT succssefully saved. Organization detail:" + nztNorm);
    }

    @Override
    public void updateNztNorm(NZTNorm nztNorm) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(nztNorm);
        logger.info("NZT successfully update. Organization detail: " + nztNorm);
    }

    @Override
    public void removeNztNorm(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        NZTNorm nztNorm = (NZTNorm) session.load(NZTNorm.class, new Integer(id));
        if (nztNorm != null) {
            session.delete(nztNorm);
        }
        logger.info("NZT successfully removed. Organization detail: " + nztNorm);
    }

    @Override
    public NZTNorm getNztNormById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        NZTNorm nztNorm = (NZTNorm) session.load(NZTNorm.class, new Integer(id));
        logger.info("NZt successfully loaded. Organization detail: " + nztNorm);
        return nztNorm;
    }

    @Override
    public List<NZTNorm> listNztNorm() {
        Session session = this.sessionFactory.getCurrentSession();
        List<NZTNorm> nztNormList = session.createQuery("from NZTNorm").list();
        for (NZTNorm nztNorm : nztNormList) {
            logger.info("Organization list:");
        }
        return nztNormList;
    }

    @Override
    public List<String> findByTableId(int idTable) {
        Session session = this.sessionFactory.getCurrentSession();
        List<String> nztNormList = session.createQuery("select distinct nameObject from NZTNorm where nztTable.id = :nztTableId ").setParameter("nztTableId", idTable).list();
        for (String nzt : nztNormList) {
            logger.info("Nzt list:"+nzt);
        }
        return nztNormList;
    }

    @Override
    public List<NZTNorm> findNztNormByNameAndIdTable(int idTable, String nameObject) {
        Session session = this.sessionFactory.getCurrentSession();
        List<NZTNorm> nztNormList = session.createQuery("from NZTNorm where nztTable.id = :nztTableId AND nameObject=:nameObject  ").setParameter("nztTableId", idTable).setParameter("nameObject", nameObject).list();
        for (NZTNorm nztNorm : nztNormList) {
            logger.info("NZT list:");
        }
        return nztNormList;

    }
}
