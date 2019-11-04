<%@page import="java.util.Iterator" %>
<%@page import="java.util.List" %>
<%@page import="organizaciitelefony.autocomplete.DummyDbb" %>
<%@page import="organizaciitelefony.dao.OrganizaciiDaoImpl" %>
<%@ page import="organizaciitelefony.autocomplete.DummyDB" %>
<%@ page import="organizaciitelefony.service.RekvizityServise" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="org.springframework.beans.factory.annotation.Qualifier" %>
<%@ page import="organizaciitelefony.model.Rekvizity" %>
<%@ page import="organizaciitelefony.service.RekvizityServiseImpl" %>
<%@ page import="organizaciitelefony.dao.OrganizaciiDao" %>
<%@ page import="organizaciitelefony.autocomplete.DummyDbBean" %>
<jsp:useBean id="rekvizityServise" class="organizaciitelefony.service.RekvizityServiseImpl" scope="session" />
<jsp:useBean id="organizaciiDao" class="organizaciitelefony.dao.OrganizaciiDaoImpl" scope="session"/>
<%

    // RekvizityServise rekvizityServise;
    // DummyDB dummy;
    //dummy.getData();
    //  System.out.println(rekvizityServise);
    // System.out.println("список организаций ");

    //System.out.println(rekvizityServise.listOrganization());
    /*class DumJsp {

        private List<Rekvizity> match = new ArrayList<Rekvizity>();
        private List<String> matched;
        @Autowired
        private RekvizityServise rekvizityServise;

        public DumJsp() {
        }

        public DumJsp(RekvizityServise rekvizityServise) {
            this.rekvizityServise = rekvizityServise;

        }


        @Autowired(required = true)
        @Qualifier(value = "rekvizityServise")
        public void setRekvizityServise(RekvizityServise rekvizityServise) {
            this.rekvizityServise = rekvizityServise;
            //DummyDbb db = new DummyDbb(this.rekvizityServise);
        }

        public List<String> getData(String query) {
            //match = this.rekvizityServise.listOrganization();
            //OrganizaciiDao organizaciiDao1=new OrganizaciiDaoImpl();
          RekvizityServise rekvizityServise=new RekvizityServiseImpl();
          ((RekvizityServiseImpl) rekvizityServise).setOrganizaciiDao(organizaciiDao);
            match=rekvizityServise.listOrganization();
            for (Rekvizity s : match) {
                matched.add(s.getName_organization());
            }
            return matched;

        }
    }


    DumJsp dumJsp = new DumJsp(rekvizityServise);*/
    @Autowired
    RekvizityServise rekvizityServise;
    String query = request.getParameter("q");
    DummyDbBean dummyDbBean=new DummyDbBean();
    //List<String> countries = new ArrayList<>();
    List<String> countries = dummyDbBean.getData(query);
    //organizaciiDao.listOrganization();
    Iterator<String> iterator = countries.iterator();
    while (iterator.hasNext()) {
        String country = (String) iterator.next();
        out.println(country);
    }
%>
