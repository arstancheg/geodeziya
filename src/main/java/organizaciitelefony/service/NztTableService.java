package organizaciitelefony.service;


import organizaciitelefony.model.NztTable;

import java.util.List;

public interface NztTableService {


    public void addNztTable(NztTable nztTable);

    public void updateNztTable(NztTable nztTable);

    public void removeNztTable(int id);

    public NztTable getNztTableById(int id);

    public List<NztTable> listNztTable();

    public List<NztTable> findByNztId(int nztId);
}
