package organizaciitelefony.controller;

import org.apache.commons.io.IOUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import organizaciitelefony.model.Dogovor;
import organizaciitelefony.model.Rekvizity;
import organizaciitelefony.russiandate.RussianDate;
import organizaciitelefony.service.DogovorService;
import organizaciitelefony.service.RekvizityServise;
import organizaciitelefony.word.CreateWord4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;


@Controller
public class DogovorController {
    @Autowired
    private DogovorService dogovorService;
    @Autowired
    private RekvizityServise rekvizityServise;

    @RequestMapping(value = "adddogovor", method = RequestMethod.GET)
    public String listDogovor(Model model) {
        model.addAttribute("dogovor", new Dogovor());
        model.addAttribute("listDogovor", this.dogovorService.listDogovor());
        List<Dogovor> match = this.dogovorService.listDogovor();
        // model.addAttribute("rekvizity", new Rekvizity());
        //  model.addAttribute("listOrganization", this.rekvizityServise.listOrganization());
     /*   for (Dogovor s : match) {
            System.out.println(s.getId());
            System.out.println(s.getFullName());
            System.out.println(s.getRekvizity());
        }*/
        return "adddogovor";
    }

    @RequestMapping(value = "/adddogovor/add", method = RequestMethod.GET)
    public String addDogovor(@ModelAttribute("dogovor") Dogovor dogovor) {
        if (dogovor.getId() == 0) {
            this.dogovorService.addDogovor(dogovor);
        } else {
            this.dogovorService.updateDogovor(dogovor);
        }

        return "redirect:/adddogovor";
    }

    @RequestMapping("/removedogovor/{id}")
    public String removeDogovor(@PathVariable("id") int id) {
        this.dogovorService.removeDogovor(id);
        return "redirect:/adddogovor";
    }
    @RequestMapping("editdogovor/{id}")
    public String editOrganization(@PathVariable("id") int id, Model model) {
        model.addAttribute("dogovor", this.dogovorService.getDogovorById(id));
        model.addAttribute("listDogovor", this.dogovorService.listDogovor());

        return "adddogovor";
    }

    @RequestMapping(value = "addword/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public String addWord(@PathVariable("id") int id, Model model) throws IOException, Docx4JException {
        //placeholder
        /*  фио заказчика fioZakazchik
            название заказчика Nameorganization
            реквизиты заказчика Rekvizit_organization
            номер договора nomerDogovora
            дата составления DateDogovor
            должность position
            дата начала DateBegin
            дата окончания DateEnd

         */
        /*System.out.println(getClass());
        System.out.println(getClass().getClassLoader());*/
       /* String path = "proekt-dogovora.docx";
        System.out.println(getClass().getClassLoader().getResource(path).toString());*/
        String userHomeDir = System.getProperty("user.home", ".");
        // String systemDir = userHomeDir + "/.collection";
        //System.out.println(systemDir);
        RussianDate russianDate = new RussianDate();
        Date currentDate = new Date();
        String currentDateDogovor = russianDate.russianDateFormat(currentDate);

        String filePathOut = System.getProperty("java.io.tmpdir") + "/proekt-dogovora1.docx";
        //String filePathOut = userHomeDir + "/proekt-dogovora1.docx";
        //String filePathOut = "D:/proekt-dogovora1.docx";
        //create docx
        CreateWord4j createWord4j = new CreateWord4j();
        String filePath1 = this.getClass().getClassLoader().getResource("1.txt").toString();

        // String filePath = this.getClass().getClassLoader().getResource("proekt-dogovora.txt").toString();
        InputStream filePath = this.getClass().getClassLoader().getResourceAsStream("proekt-dogovora.docx");
        // filePath = filePath.replace("file:/", "");
        // System.out.println(filePath);

        // System.out.println(userHomeDir);
        /* final String filePath = "https:\\\\s3.us-east-2.amazonaws.com/elasticbeanstalk-us-east-2-938128964000/proekt-dogovora.docx";
         */
        WordprocessingMLPackage template = createWord4j.getTemplate(filePath);
        //WordprocessingMLPackage template = createWord4j.getTemplate("D:/proekt-dogovora.docx");
        // System.out.println("do " + template);
        Dogovor dogovor = this.dogovorService.getDogovorById(id);
        String placeholder = "Nameorganization";
        String toAdd = dogovor.getRekvizity().getNameOrganization();
        createWord4j.replacePlaceholder(template, toAdd, placeholder);

        String placeholder1 = "Rekvizit_organization";
        String toAdd1 = dogovor.getRekvizity().getRekvizitOrganization();
        createWord4j.replacePlaceholder(template, toAdd1, placeholder1);
        //insert DateDogovor
        String placeholder2 = "DateDogovor";
        String toAdd2 = currentDateDogovor;
        createWord4j.replacePlaceholder(template, toAdd2, placeholder2);

        //insert DateBegin
        String dateBegin = russianDate.russianDateFormat(dogovor.getDateBegin());
        String placeholder3 = "DateBegin";
        String toAdd3 = dateBegin;
        createWord4j.replacePlaceholder(template, toAdd3, placeholder3);

        //insert DateEnd
        String dateEnd = russianDate.russianDateFormat(dogovor.getDateEnd());
        String placeholder4 = "DateEnd";
        String toAdd4 = dateEnd;
        createWord4j.replacePlaceholder(template, toAdd4, placeholder4);

        //insert fioZakazchik
        createWord4j.replacePlaceholder(template, dogovor.getRekvizity().getFullName(), "fioZakazchik");

        //insert position
        createWord4j.replacePlaceholder(template, dogovor.getRekvizity().getPosition().toLowerCase(), "position");

        createWord4j.writeDocxToStream(template, filePathOut);
        //System.out.println("posle " + template);
        // System.out.println(this.rekvizityServise.getOrganizationById(id).getRekvizit_organization());





/*            InputStream in = this.getClass().getClassLoader().getResourceAsStream("proekt-dogovora.docx");
        if (in == null) {
            throw new FileNotFoundException("readFilesInBytes: File " + filePathOut
                    + " does not exist");
        }
        return IOUtils.toByteArray(in);*/
        model.addAttribute("filename", filePathOut);
        //model.addAttribute("test","test2");
        return "docx/test2";
    }
}

