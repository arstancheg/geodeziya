package organizaciitelefony.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import organizaciitelefony.model.NztTable;

import java.util.List;
@Repository
public class NztTableDaoImpl implements NztTableDao {
    private static final Logger logger = LoggerFactory.getLogger(OrganizaciiDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addNztTable(NztTable nztTable) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(nztTable);
        logger.info("NztTable succssefully saved. NztTable detail:" + nztTable);
    }

    @Override
    public void updateNztTable(NztTable nztTable) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(nztTable);
        logger.info("NZTTable successfully update. NztTable detail: " + nztTable);
    }

    @Override
    public void removeNztTable(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        NztTable nztTable = (NztTable) session.load(NztTable.class, new Integer(id));
        if (nztTable != null) {
            session.delete(nztTable);
        }
        logger.info("NZTTable successfully removed. NztTable detail: " + nztTable);
    }

    @Override
    public NztTable getNztTableById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        NztTable nztTable = (NztTable) session.load(NztTable.class, new Integer(id));
        logger.info("NZt successfully loaded. NztTable detail: " + nztTable);
        return nztTable;
    }

    @Override
    public List<NztTable> listNztTable() {
        Session session = this.sessionFactory.getCurrentSession();
        List<NztTable> nztTableList = session.createQuery("from NztTable ").list();
        for (NztTable nztTable : nztTableList) {
            logger.info("Organization list:");
        }
        return nztTableList;
    }
    @Override
    public List<NztTable> findByNztId(int nztId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<NztTable> nztTables = session.createQuery("from NztTable where nzt.id=:nztId").setParameter("nztId", nztId).list();
        for (NztTable nztTable : nztTables) {
            logger.info("Organization list:"+ nztTable);
        }
        return nztTables;
    }
}
