package organizaciitelefony.dao;

import organizaciitelefony.model.Dogovor;
import organizaciitelefony.model.Rekvizity;

import java.util.List;

public interface DogovorDao {
    public void addDogovor(Dogovor dogovor);

    public void updateDogovor(Dogovor dogovor);

    public void removeDogovor(int id);

    public Dogovor getDogovorById(int id);

    public List<Dogovor> listDogovor();


}
