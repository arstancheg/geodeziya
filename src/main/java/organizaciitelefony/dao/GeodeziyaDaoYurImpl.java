package organizaciitelefony.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import organizaciitelefony.model.Geodeziya;
import organizaciitelefony.model.GeodeziyaYur;

import java.util.List;

@Repository
public class GeodeziyaDaoYurImpl implements GeodeziyaDaoYur {
    @Autowired
    SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addGeodeziyaYur(GeodeziyaYur geodeziyaYur) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(geodeziyaYur);
    }

    @Override
    public void updateGeodeziyaYur(GeodeziyaYur geodeziyaYur) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(geodeziyaYur);
    }

    @Override
    public void removeGeodeziyaYur(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        GeodeziyaYur geodeziyaYur = (GeodeziyaYur) session.load(GeodeziyaYur.class, new Integer(id));
        if (geodeziyaYur != null) {
            session.delete(geodeziyaYur);
        }
    }

    @Override
    public GeodeziyaYur getGeodeziyaYurById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        GeodeziyaYur geodeziyaYur = (GeodeziyaYur) session.load(GeodeziyaYur.class, new Integer(id));
        return geodeziyaYur;
    }

    @Override
    public List<GeodeziyaYur> listGeodeziyaYur() {
        Session session = this.sessionFactory.getCurrentSession();
        List<GeodeziyaYur> geodeziyaYurListList = session.createQuery("from GeodeziyaYur").list();
        return geodeziyaYurListList;
    }
}
