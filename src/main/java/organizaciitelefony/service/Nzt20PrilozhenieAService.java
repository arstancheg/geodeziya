package organizaciitelefony.service;

import org.springframework.stereotype.Service;
import organizaciitelefony.model.Nzt20PrilozhenieA;

import java.util.List;


public interface Nzt20PrilozhenieAService {
    public List<Nzt20PrilozhenieA> listNzt20PrilozhenieA();
    public List<Nzt20PrilozhenieA> findByIdVidzdaniyaInPrilozhenieA(int idVidzdaniya);
}
