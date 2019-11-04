package organizaciitelefony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizaciitelefony.dao.NztTableDao;
import organizaciitelefony.model.NztTable;

import java.util.List;
@Service
public class NztTableServiceImpl implements NztTableService {
    @Autowired
    private NztTableDao nztTableDao;

    @Override
    @Transactional
    public void addNztTable(NztTable nztTable) {
        this.nztTableDao.addNztTable(nztTable);
    }

    @Override
    @Transactional
    public void updateNztTable(NztTable nztTable) {
this.nztTableDao.updateNztTable(nztTable);
    }

    @Override
    @Transactional
    public void removeNztTable(int id) {
this.nztTableDao.removeNztTable(id);
    }

    @Override
    @Transactional
    public NztTable getNztTableById(int id) {
        return  this.nztTableDao.getNztTableById(id);
    }

    @Override
    @Transactional
    public List<NztTable> listNztTable() {
        return this.nztTableDao.listNztTable();
    }

    @Override
    @Transactional
    public List<NztTable> findByNztId(int nztId){return  this.nztTableDao.findByNztId(nztId);}
}
