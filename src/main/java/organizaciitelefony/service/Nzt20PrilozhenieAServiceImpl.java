package organizaciitelefony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizaciitelefony.dao.Nzt20PrilozhenieADao;
import organizaciitelefony.model.Nzt20PrilozhenieA;

import java.util.List;

@Service
public class Nzt20PrilozhenieAServiceImpl implements Nzt20PrilozhenieAService  {
    @Autowired
    private Nzt20PrilozhenieADao nzt20PrilozhenieADao;
    @Override
    @Transactional
    public List<Nzt20PrilozhenieA> listNzt20PrilozhenieA() {
        return this.nzt20PrilozhenieADao.listNzt20PrilozhenieA();
    }

    @Override
    @Transactional
    public List<Nzt20PrilozhenieA> findByIdVidzdaniyaInPrilozhenieA(int idVidzdaniya) {
        return this.nzt20PrilozhenieADao.findByIdVidzdaniyaInPrilozhenieA(idVidzdaniya);
    }
}
