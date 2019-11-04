package organizaciitelefony.dao;

import organizaciitelefony.model.Nzt20PrilozhenieA;

import java.util.List;

public interface Nzt20PrilozhenieADao {
    public List<Nzt20PrilozhenieA> listNzt20PrilozhenieA();
    public List<Nzt20PrilozhenieA> findByIdVidzdaniyaInPrilozhenieA(int idVidzdaniya);
}
