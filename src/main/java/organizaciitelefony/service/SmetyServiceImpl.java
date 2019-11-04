package organizaciitelefony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizaciitelefony.dao.SmetyDao;
import organizaciitelefony.model.Smety;

import java.util.List;

@Service("smetyService")
public class SmetyServiceImpl implements SmetyService {
    @Autowired
    private SmetyDao smetyDao;

    @Override
    @Transactional
    public void addSmeta(Smety smety) {
        this.smetyDao.addSmeta(smety);
    }

    @Override
    @Transactional
    public void updateSmeta(Smety smety) {
        this.smetyDao.updateSmeta(smety);
    }

    @Override
    @Transactional
    public void removeSmeta(int id) {
        this.smetyDao.removeSmeta(id);

    }

    @Override
    @Transactional
    public Smety getSmetaById(int id) {
        return this.smetyDao.getSmetaById(id);
    }

    @Override
    @Transactional
    public List<Smety> listSmety() {
        return this.smetyDao.listSmety();
    }
}
