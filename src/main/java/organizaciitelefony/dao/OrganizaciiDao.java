package organizaciitelefony.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import organizaciitelefony.model.Rekvizity;

import java.util.List;

/*public interface OrganizaciiDao extends CrudRepository<Rekvizity, Integer> {*/
        public interface OrganizaciiDao  {
        public void addOrganization(Rekvizity rekvizity);

        public void updateOrganization(Rekvizity rekvizity);

        public void removeOrganization(int id);

        public Rekvizity getOrganizationById(int id);

        public List<Rekvizity> listOrganization();

        public List<String> search(String keyword);


       public List<Rekvizity> findByNameOrganization(String nameOrganization);




    }

