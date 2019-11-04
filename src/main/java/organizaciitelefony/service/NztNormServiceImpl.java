package organizaciitelefony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizaciitelefony.dao.NztNormDao;
import organizaciitelefony.model.NZTNorm;

import java.util.List;

@Service("nztNormService")
public class NztNormServiceImpl implements NztNormService {
    @Autowired
    private NztNormDao nztNormDao;

    public void setNztNormDao(NztNormDao nztNormDao) {
        this.nztNormDao = nztNormDao;
    }

    @Override
    @Transactional
    public void addNztNorm(NZTNorm nztNorm) {
        this.nztNormDao.addNztNorm(nztNorm);
    }

    @Override
    @Transactional
    public void updateNztNorm(NZTNorm nztNorm) {
        this.nztNormDao.updateNztNorm(nztNorm);

    }

    @Override
    @Transactional
    public void removeNztNorm(int id) {
        this.nztNormDao.removeNztNorm(id);
    }

    @Override
    @Transactional
    public NZTNorm getNztNormById(int id) {
        return this.nztNormDao.getNztNormById(id);
    }

    @Override
    @Transactional
    public List<NZTNorm> listNztNorm() {
        return this.nztNormDao.listNztNorm();
    }

    @Override
    @Transactional
    public List<String> findByTableId(int idTable) {
        return this.nztNormDao.findByTableId(idTable);
    }

    @Override
    @Transactional
    public List<NZTNorm> findNztNormByNameAndIdTable(int idTable, String nameObject) {
        return this.nztNormDao.findNztNormByNameAndIdTable(idTable, nameObject);
    }
}
