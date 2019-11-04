package organizaciitelefony.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plutext.jaxb.svg11.G;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import organizaciitelefony.model.Geodeziya;

import java.util.List;
@Repository
public class GeodeziyaDaoImpl implements GeodeziyaDao {
    @Autowired
    SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addGeodeziya(Geodeziya geodeziya) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(geodeziya);
    }

    @Override
    public void updateGeodeziya(Geodeziya geodeziya) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(geodeziya);
    }

    @Override
    public void removeGeodeziya(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Geodeziya geodeziya = (Geodeziya) session.load(Geodeziya.class, new Integer(id));
        if (geodeziya != null) {
            session.delete(geodeziya);
        }
    }

    @Override
    public Geodeziya getGeodeziyaById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Geodeziya geodeziya = (Geodeziya) session.load(Geodeziya.class, new Integer(id));
        return geodeziya;
    }

    @Override
    public List<Geodeziya> listGeodeziya() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Geodeziya> geodeziyaList = session.createQuery("from Geodeziya").list();
        return geodeziyaList;
    }
}
