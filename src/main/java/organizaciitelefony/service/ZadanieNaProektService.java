package organizaciitelefony.service;

import organizaciitelefony.model.ZadanieNaProekt;

import java.util.List;

public interface ZadanieNaProektService {
    public void addZadanie(ZadanieNaProekt zadanieNaProekt);

    public void updateZadanie(ZadanieNaProekt zadanieNaProekt);

    public void removeZadanie(int id);

    public ZadanieNaProekt getZadanieById(int id);

    public List<ZadanieNaProekt> listZadanie();
}
