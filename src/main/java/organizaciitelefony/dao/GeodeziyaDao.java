package organizaciitelefony.dao;

import org.springframework.stereotype.Repository;
import organizaciitelefony.model.Geodeziya;

import java.util.List;


public interface GeodeziyaDao {
    public void addGeodeziya(Geodeziya geodeziya);

    public void updateGeodeziya(Geodeziya geodeziya);

    public void removeGeodeziya(int id);

    public Geodeziya getGeodeziyaById(int id);

    public List<Geodeziya> listGeodeziya();
}
