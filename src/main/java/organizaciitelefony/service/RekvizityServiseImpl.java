package organizaciitelefony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import organizaciitelefony.dao.OrganizaciiDao;
import organizaciitelefony.model.Rekvizity;

import java.util.List;

@Service("rekvizityServise")
public class RekvizityServiseImpl implements RekvizityServise {
    @Autowired
    private OrganizaciiDao organizaciiDao;

    public void setOrganizaciiDao(OrganizaciiDao organizaciiDao) {
        this.organizaciiDao = organizaciiDao;
    }

    @Override
    @Transactional
    public void addOrganization(Rekvizity rekvizity) {
        this.organizaciiDao.addOrganization(rekvizity);

    }

    @Override
    @Transactional
    public void updateOrganization(Rekvizity rekvizity) {
        this.organizaciiDao.updateOrganization(rekvizity);

    }

    @Override
    @Transactional
    public void removeOrganization(int id) {
        this.organizaciiDao.removeOrganization(id);

    }

    @Override
    @Transactional
    public Rekvizity getOrganizationById(int id) {

        return this.organizaciiDao.getOrganizationById(id);
    }

    @Override
    @Transactional
    public List<Rekvizity> listOrganization() {

        return this.organizaciiDao.listOrganization();
    }

    @Override
    @Transactional
    public List<String> search(String keyword) {
        return this.organizaciiDao.search(keyword);
    }

    @Override
    @Transactional
    public List<Rekvizity> findByNameOrganization(String nameOrganization) {
        return this.organizaciiDao.findByNameOrganization(nameOrganization);
    }

    private void initObject1() {
        System.out.println("initRekvService1");
    }

    private void destroyObject1() {
        System.out.println("DestroyService1");
    }

    private void initObject2() {
        System.out.println("initRekvService2");
    }
}
