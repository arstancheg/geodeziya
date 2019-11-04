package organizaciitelefony.service;

import organizaciitelefony.model.Smety;

import java.util.List;

public interface SmetyService {
    public void addSmeta(Smety smety);

    public void updateSmeta(Smety smety);

    public void removeSmeta(int id);

    public Smety getSmetaById(int id);

    public List<Smety> listSmety();
}
