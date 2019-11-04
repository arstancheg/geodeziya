package organizaciitelefony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizaciitelefony.dao.NztDao;
import organizaciitelefony.model.Nzt;

import java.util.List;
@Service
public class NztServiceImpl implements NztService {
    @Autowired
    private NztDao nztDao;

    public void setNztDao(NztDao nztDao) {
        this.nztDao = nztDao;
    }

    @Override
    @Transactional
    public void addNzt(Nzt nzt) {this.nztDao.addNzt(nzt);

    }

    @Override
    @Transactional
    public void updateNzt(Nzt nzt) {
        this.nztDao.updateNzt(nzt);

    }

    @Override
    @Transactional
    public void removeNzt(int id) {
this.nztDao.removeNzt(id);
    }

    @Override
    @Transactional
    public Nzt getNztById(int id) {
       return  this.nztDao.getNztById(id);
    }

    @Override
    @Transactional
    public List<Nzt> listNzt() {
        return this.nztDao.listNzt();
    }
}
