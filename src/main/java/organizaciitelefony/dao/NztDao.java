package organizaciitelefony.dao;


import organizaciitelefony.model.Nzt;

import java.util.List;

public interface NztDao {
    public void addNzt(Nzt nzt);

    public void updateNzt(Nzt nzt);

    public void removeNzt(int id);

    public Nzt getNztById(int id);

    public List<Nzt> listNzt();

}
