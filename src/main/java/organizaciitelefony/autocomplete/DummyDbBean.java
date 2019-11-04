package organizaciitelefony.autocomplete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;
import organizaciitelefony.model.Rekvizity;
import organizaciitelefony.service.RekvizityServise;
import organizaciitelefony.service.RekvizityServiseImpl;

import java.util.ArrayList;
import java.util.List;
@Component
public class DummyDbBean {
    private List<Rekvizity> match = new ArrayList<Rekvizity>();
    private List<String> matched=new ArrayList<>();
Rekvizity rekvizity=new Rekvizity();
    @Autowired
    private RekvizityServise rekvizityServise;
public DummyDbBean(RekvizityServise rekvizityServise){
    this.rekvizityServise=rekvizityServise;
}


    //More code
    public List<String> getData(String string){

        match=this.rekvizityServise.listOrganization();
        for (Rekvizity s : match) {
            matched.add(s.getNameOrganization());
        }
        return matched;
    }
}