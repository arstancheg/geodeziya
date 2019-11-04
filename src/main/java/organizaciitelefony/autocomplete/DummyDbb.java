package organizaciitelefony.autocomplete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import organizaciitelefony.model.Rekvizity;
import organizaciitelefony.service.RekvizityServise;
import organizaciitelefony.service.RekvizityServiseImpl;

import java.util.List;

@Component
public class DummyDbb{

    private RekvizityServise rekvizityServise;

    public DummyDbb() {

//        List<Rekvizity> listRekv= rekvizityServise.listOrganization();
    }



    @Autowired(required = true)
    @Qualifier(value = "rekvizityServise")
    public  void setRekvizityServise(RekvizityServise rekvizityServise) {
        this.rekvizityServise = rekvizityServise;

    }

    public  List<Rekvizity> getListRekvizityServise() {

        List<Rekvizity> listRekvizity = rekvizityServise.listOrganization();
        return listRekvizity;
    }
}
