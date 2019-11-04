package organizaciitelefony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizaciitelefony.dao.DogovorDao;
import organizaciitelefony.model.Dogovor;

import java.util.List;

@Service("dogovorService")
public class DogovorServiceImpl implements DogovorService {
    @Autowired
    private DogovorDao dogovorDao;

    @Override
    @Transactional
    public void addDogovor(Dogovor dogovor) {
        this.dogovorDao.addDogovor(dogovor);


    }

    @Override
    @Transactional
    public void updateDogovor(Dogovor dogovor) {
        this.dogovorDao.updateDogovor(dogovor);
    }

    @Override
    @Transactional
    public void removeDogovor(int id) {
        this.dogovorDao.removeDogovor(id);
    }

    @Override
    @Transactional
    public Dogovor getDogovorById(int id) {
        return this.dogovorDao.getDogovorById(id);
    }

    @Override
    @Transactional
    public List<Dogovor> listDogovor() {
        return this.dogovorDao.listDogovor();
    }
}
