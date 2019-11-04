package organizaciitelefony.dao;

import organizaciitelefony.model.NZTNorm;

import java.util.List;

public interface NztNormDao {
    public void addNztNorm(NZTNorm nztNorm);

    public void updateNztNorm(NZTNorm nztNorm);

    public void removeNztNorm(int id);

    public NZTNorm getNztNormById(int id);

    public List<NZTNorm> listNztNorm();

    public List<String> findByTableId(int idTable);

    public List<NZTNorm> findNztNormByNameAndIdTable(int idTable, String nameObject);
}
