package organizaciitelefony.service;

import organizaciitelefony.model.Rekvizity;

import java.util.List;

public interface RekvizityServise {
    public void addOrganization(Rekvizity rekvizity);

    public void updateOrganization(Rekvizity rekvizity);

    public void removeOrganization(int id);

    public Rekvizity getOrganizationById(int id);

    public List<Rekvizity> listOrganization();

    public List<String> search(String keyword);

    public List<Rekvizity> findByNameOrganization(String nameOrganization);
}


