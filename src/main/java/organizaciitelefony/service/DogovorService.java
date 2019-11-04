package organizaciitelefony.service;

import organizaciitelefony.model.Dogovor;

import java.util.List;

public interface DogovorService {
    public void addDogovor(Dogovor dogovor);

    public void updateDogovor(Dogovor dogovor);

    public void removeDogovor(int id);

    public Dogovor getDogovorById(int id);

    public List<Dogovor> listDogovor();
}
