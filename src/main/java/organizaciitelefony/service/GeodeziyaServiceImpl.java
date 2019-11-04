package organizaciitelefony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizaciitelefony.dao.GeodeziyaDao;
import organizaciitelefony.model.Geodeziya;

import java.util.List;
@Service("geodeziyaService")
public class GeodeziyaServiceImpl implements GeodeziyaService {
    @Autowired
    private GeodeziyaDao geodeziyaDao;

    @Override
    @Transactional
    public void addGeodeziya(Geodeziya geodeziya) {
        this.geodeziyaDao.addGeodeziya(geodeziya);
    }

    @Override
    @Transactional
    public void updateGeodeziya(Geodeziya geodeziya) {
this.geodeziyaDao.updateGeodeziya(geodeziya);
    }

    @Override
    @Transactional
    public void removeGeodeziya(int id) {
this.geodeziyaDao.removeGeodeziya(id);
    }

    @Override
    @Transactional
    public Geodeziya getGeodeziyaById(int id) {
        return this.geodeziyaDao.getGeodeziyaById(id);
    }

    @Override
    @Transactional
    public List<Geodeziya> listGeodeziya() {
        return this.geodeziyaDao.listGeodeziya();
    }
}
