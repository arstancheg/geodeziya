package organizaciitelefony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizaciitelefony.dao.ZadanieNaProektDao;
import organizaciitelefony.model.ZadanieNaProekt;

import java.util.List;

@Service("zadanieNaProektService")
public class ZadanieNaProektServiceImpl implements ZadanieNaProektService {
    @Autowired
    private ZadanieNaProektDao zadanieNaProektDao;

    @Override
    @Transactional
    public void addZadanie(ZadanieNaProekt zadanieNaProekt) {
        this.zadanieNaProektDao.addZadanie(zadanieNaProekt);
    }

    @Override
    @Transactional
    public void updateZadanie(ZadanieNaProekt zadanieNaProekt) {
        this.zadanieNaProektDao.updateZadanie(zadanieNaProekt);
    }

    @Override
    @Transactional
    public void removeZadanie(int id) {
        this.zadanieNaProektDao.removeZadanie(id);
    }

    @Override
    @Transactional
    public ZadanieNaProekt getZadanieById(int id) {
       return this.zadanieNaProektDao.getZadanieById(id);
    }

    @Override
    @Transactional
    public List<ZadanieNaProekt> listZadanie() {
        return this.zadanieNaProektDao.listZadanie();
    }
}
