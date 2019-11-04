package organizaciitelefony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizaciitelefony.dao.GeodeziyaDao;
import organizaciitelefony.dao.GeodeziyaDaoYur;
import organizaciitelefony.model.Geodeziya;
import organizaciitelefony.model.GeodeziyaYur;

import java.util.List;

@Service("geodeziyaServiceYur")
public class GeodeziyaServiceYurImpl implements GeodeziyaServiceYur{
    @Autowired
    private GeodeziyaDaoYur geodeziyaDaoYur;

    @Override
    @Transactional
    public void addGeodeziyaYur(GeodeziyaYur geodeziyaYur) {
        this.geodeziyaDaoYur.addGeodeziyaYur(geodeziyaYur);
    }

    @Override
    @Transactional
    public void updateGeodeziyaYur(GeodeziyaYur geodeziyaYur) {
this.geodeziyaDaoYur.updateGeodeziyaYur(geodeziyaYur);
    }

    @Override
    @Transactional
    public void removeGeodeziyaYur(int id) {
this.geodeziyaDaoYur.removeGeodeziyaYur(id);
    }

    @Override
    @Transactional
    public GeodeziyaYur getGeodeziyaYurById(int id) {
        return this.geodeziyaDaoYur.getGeodeziyaYurById(id);
    }

    @Override
    @Transactional
    public List<GeodeziyaYur> listGeodeziyaYur() {
        return this.geodeziyaDaoYur.listGeodeziyaYur();
    }
}
