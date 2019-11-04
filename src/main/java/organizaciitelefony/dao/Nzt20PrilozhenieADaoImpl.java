package organizaciitelefony.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import organizaciitelefony.model.Nzt20PrilozhenieA;

import java.util.List;

@Repository
public class Nzt20PrilozhenieADaoImpl implements Nzt20PrilozhenieADao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Nzt20PrilozhenieA> listNzt20PrilozhenieA() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Nzt20PrilozhenieA> nztList = session.createQuery("from Nzt20PrilozhenieA").list();

        return nztList;
    }

    @Override
    public List<Nzt20PrilozhenieA> findByIdVidzdaniyaInPrilozhenieA(int idVidzdaniya) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Nzt20PrilozhenieA> nzt20PrilozhenieAList = session.createQuery("from Nzt20PrilozhenieA where vidZdaniya.id = :idVidzdaniya ").setParameter("idVidzdaniya", idVidzdaniya).list();

        return nzt20PrilozhenieAList;
    }
}

