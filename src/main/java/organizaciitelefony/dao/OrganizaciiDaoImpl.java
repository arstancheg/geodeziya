package organizaciitelefony.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import organizaciitelefony.model.Rekvizity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;
import java.util.List;

@Repository
public class OrganizaciiDaoImpl implements OrganizaciiDao  {
    private static final Logger logger = LoggerFactory.getLogger(OrganizaciiDao.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addOrganization(Rekvizity rekvizity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(rekvizity);
        logger.info("Rekvizity succssefully saved. Organization detail:" + rekvizity);
    }

    @Override
    public void updateOrganization(Rekvizity rekvizity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(rekvizity);
        logger.info("Organization successfully apdate. Organization detail: " + rekvizity);

    }

    @Override
    public void removeOrganization(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Rekvizity rekvizity = (Rekvizity) session.load(Rekvizity.class, new Integer(id));
        if (rekvizity != null) {
            session.delete(rekvizity);
        }
        logger.info("Organization successfully removed. Organization detail: " + rekvizity);

    }

    @Override
    public Rekvizity getOrganizationById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Rekvizity rekvizity = (Rekvizity) session.load(Rekvizity.class, new Integer(id));
        logger.info("Organization successfully loaded. Organization detail: " + rekvizity);
        return rekvizity;
    }

    @Override
    public List<Rekvizity> listOrganization() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Rekvizity> rekvizityList = session.createQuery("from Rekvizity").list();
        for (Rekvizity rekvizity : rekvizityList) {
            logger.info("Organization list:");
        }
        return rekvizityList;
    }

    @Override
    public List<Rekvizity> findByNameOrganization(String nameOrganization) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Rekvizity> rekvizityOrg = session.createQuery("from Rekvizity where nameOrganization=:nameOrganization").setParameter("nameOrganization", nameOrganization).list();
        for (Rekvizity rekvizity : rekvizityOrg) {
            logger.info("Organization list:"+ rekvizity);
        }
        return rekvizityOrg;
    }

    @Override
    public List<String> search(String keyword) {
        Session session = this.sessionFactory.getCurrentSession();
        List<String> nameOrganizationList = session.createQuery("select nameOrganization from Rekvizity where nameOrganization like :keyword ").setParameter("keyword", "%" + keyword + "%").list();

        return nameOrganizationList;
    }

    public void initObject(){
        System.out.println("init");
    }
    public void destroyObject(){
        System.out.println("destroy");
    }
    public void destroyDAO(){
        System.out.println("destroyDao");
    }
}
