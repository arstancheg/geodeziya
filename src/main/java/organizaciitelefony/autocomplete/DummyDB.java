package organizaciitelefony.autocomplete;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import organizaciitelefony.dao.OrganizaciiDao;
import organizaciitelefony.dao.OrganizaciiDaoImpl;
import organizaciitelefony.service.RekvizityServise;
import organizaciitelefony.model.Rekvizity;
import organizaciitelefony.service.RekvizityServiseImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

/*public class DummyDB {
    private int totalCountries;
    private String data = "Afghanistan,	Albania, Zimbabwe";
    private List<String> countries;
    public DummyDB() {
        countries = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(data, ",");

        while(st.hasMoreTokens()) {
            countries.add(st.nextToken().trim());
        }
        totalCountries = countries.size();
    }

    public List<String> getData(String query) {
        String country = null;
        query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for(int i=0; i<totalCountries; i++) {
            country = countries.get(i).toLowerCase();
            if(country.startsWith(query)) {
                matched.add(countries.get(i));
            }
        }
        return matched;
    }
}*/
@Component

public class DummyDB {


        private List<Rekvizity> match = new ArrayList<Rekvizity>();
        private List<String> matched;

        private RekvizityServise rekvizityServise;




        @Autowired
        @Qualifier("rekvizityServise")
        public void setRekvizityServise(RekvizityServise rekvizityServise) {
            this.rekvizityServise = rekvizityServise;
             //System.out.println(this.rekvizityServise.listOrganization());

        }

    public RekvizityServise getRekvizityServise() {
        this.rekvizityServise.listOrganization();
            return rekvizityServise;

    }

    public void setMatch(List<Rekvizity> match) {
            this.match = match;
           // System.out.println(match);
        }

        public List<String> getData(String query) {
          //  DummyDbb dummy=new DummyDbb(this.rekvizityServise);
           // dummy.getRekvizityServise();
            match=this.rekvizityServise.listOrganization();
            for (Rekvizity s : match) {
                matched.add(s.getNameOrganization());
            }
            //stOrganization1();
            // Rekvizity rekvizity = new Rekvizity();
String name = null;
        query = query.toLowerCase();



            // matched.add("Ghbaksdjlg");
            // RekvizityServiseImpl rekvizityServise = new RekvizityServiseImpl();
            //System.out.println(matched);


            return matched;
        }



}
