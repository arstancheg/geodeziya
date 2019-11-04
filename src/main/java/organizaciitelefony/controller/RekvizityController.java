package organizaciitelefony.controller;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.web.bind.annotation.*;
import organizaciitelefony.autocomplete.DummyDbBean;
import organizaciitelefony.model.Rekvizity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import organizaciitelefony.service.RekvizityServise;
import organizaciitelefony.word.CreateWord;
import organizaciitelefony.word.CreateWord4j;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
public class RekvizityController {
    @Autowired
    private RekvizityServise rekvizityServise;
/*

    @Autowired(required = true)
    @Qualifier(value = "rekvizityServise")
    public void setRekvizityServise(RekvizityServise rekvizityServise) {
        this.rekvizityServise = rekvizityServise;
    }
*/


    @RequestMapping(value = "organizacii", method = RequestMethod.GET)
    public String listOrganization(Model model) {
        model.addAttribute("rekvizity", new Rekvizity());
        model.addAttribute("listOrganization", this.rekvizityServise.listOrganization());

        return "organizacii";
    }

    @RequestMapping(value = "/organizacii/add", method = RequestMethod.GET)
    public String addOrganization(@ModelAttribute("rekvizity") Rekvizity rekvizity) {
        if (rekvizity.getId() == 0) {
            this.rekvizityServise.addOrganization(rekvizity);
        } else {
            this.rekvizityServise.updateOrganization(rekvizity);
        }

        return "redirect:/organizacii";
    }

    @RequestMapping("/remove/{id}")
    public String removeOrganization(@PathVariable("id") int id) {
        this.rekvizityServise.removeOrganization(id);

        return "redirect:/organizacii";
    }

    @RequestMapping("edit/{id}")
    public String editOrganization(@PathVariable("id") int id, Model model) {
        model.addAttribute("rekvizity", this.rekvizityServise.getOrganizationById(id));
        model.addAttribute("listOrganization", this.rekvizityServise.listOrganization());

        return "organizacii";
    }

    /*    @RequestMapping("addword/{id}")
        public String addWord(@PathVariable("id") int id, Model model, Rekvizity rekvizity) {
            CreateWord createWord = new CreateWord();
            createWord.createWord(this.rekvizityServise, id);
            System.out.println(this.rekvizityServise.getOrganizationById(id).getRekvizit_organization());

            return "redirect:/organizacii";
        }*/
/*
    @RequestMapping("addword/{id}")
    public String addWord(@PathVariable("id") int id, Model model, Rekvizity rekvizity) throws IOException, Docx4JException {
        CreateWord4j createWord4j = new CreateWord4j();
        WordprocessingMLPackage template = createWord4j.getTemplate("D:/proekt-dogovora.docx");
       // System.out.println("do " + template);
        String placeholder = "Nameorganization";
        String toAdd = this.rekvizityServise.getOrganizationById(id).getNameOrganization();
        String placeholder1 = "Rekvizit_organization";
        String toAdd1 = this.rekvizityServise.getOrganizationById(id).getRekvizitOrganization();

        createWord4j.replacePlaceholder(template, toAdd, placeholder);
        createWord4j.replacePlaceholder(template, toAdd1, placeholder1);
        createWord4j.writeDocxToStream(template, "D:/proekt-dogovora1.docx");
        //System.out.println("posle " + template);
       // System.out.println(this.rekvizityServise.getOrganizationById(id).getRekvizit_organization());

        return "redirect:/organizacii";
    }
*/

    @RequestMapping("organizationdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("rekvizity", this.rekvizityServise.getOrganizationById(id));
        return "organizationdata";
    }

    @RequestMapping(value = "organizationdatasearch", method = RequestMethod.GET)

    public String findByName(@RequestParam(required = false) String nameOrganization, Model model) {
        System.out.println(nameOrganization);
        model.addAttribute("rekvizity", new Rekvizity());

        model.addAttribute("listOrganization", this.rekvizityServise.findByNameOrganization(nameOrganization));
        System.out.println(this.rekvizityServise.findByNameOrganization(nameOrganization));
        return "organizationdatasearch";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ResponseBody
    public List<String> search(HttpServletRequest request) {
        System.out.println(request.getParameter("term"));
        return this.rekvizityServise.search(request.getParameter("term"));
    }
    @RequestMapping(value = "searchid", method = RequestMethod.GET)
    @ResponseBody
    public int searchId(HttpServletRequest request) {
        System.out.println(request.getParameter("nameOrg"));
        int id = 0;
        List<Rekvizity> match =this.rekvizityServise.findByNameOrganization(request.getParameter("nameOrg"));
       for (Rekvizity r: match){
          id=r.getId();
       }

        return id;
    }


}
