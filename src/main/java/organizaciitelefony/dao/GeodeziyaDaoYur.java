package organizaciitelefony.dao;

import organizaciitelefony.model.Geodeziya;
import organizaciitelefony.model.GeodeziyaYur;

import java.util.List;


public interface GeodeziyaDaoYur {
    public void addGeodeziyaYur(GeodeziyaYur geodeziyaYur);

    public void updateGeodeziyaYur(GeodeziyaYur geodeziyaYur);

    public void removeGeodeziyaYur(int id);

    public GeodeziyaYur getGeodeziyaYurById(int id);

    public List<GeodeziyaYur> listGeodeziyaYur();
}
