package organizaciitelefony.controller;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import organizaciitelefony.model.Dogovor;
import organizaciitelefony.model.Geodeziya;
import organizaciitelefony.model.GeodeziyaYur;
import organizaciitelefony.russiandate.MoneyPropis;
import organizaciitelefony.russiandate.RussianDate;
import organizaciitelefony.service.GeodeziyaService;
import organizaciitelefony.service.GeodeziyaServiceYur;
import organizaciitelefony.word.CreateWord4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
public class GeodeziyaController {
    @Autowired
    private GeodeziyaService geodeziyaService;
    @Autowired
    private GeodeziyaServiceYur geodeziyaServiceYur;

    @RequestMapping(value = "addgeo", method = RequestMethod.GET)
    public String listGeo(Model model) {
        model.addAttribute("geodeziya", new Geodeziya());
        model.addAttribute("listGeodeziya", this.geodeziyaService.listGeodeziya());

        return "addgeo";
    }

    @RequestMapping(value = "/addgeo/add", method = RequestMethod.GET)
    public String addGeo(@ModelAttribute("geodeziya") Geodeziya geodeziya) {
        if (geodeziya.getId() == 0) {
            this.geodeziyaService.addGeodeziya(geodeziya);
        } else {
            this.geodeziyaService.updateGeodeziya(geodeziya);
        }

        return "redirect:/addgeo";
    }

    @RequestMapping(value = "addgeoyur", method = RequestMethod.GET)
    public String listGeoYur(Model model) {
        model.addAttribute("geodeziyaYur", new GeodeziyaYur());
        model.addAttribute("listGeodeziyaYur", this.geodeziyaServiceYur.listGeodeziyaYur());

        return "addgeoyur";
    }

    @RequestMapping(value = "/addgeoyur/add", method = RequestMethod.GET)
    public String addGeoYur(@ModelAttribute("geodeziyaYur") GeodeziyaYur geodeziyaYur) {
        if (geodeziyaYur.getId() == 0) {
            this.geodeziyaServiceYur.addGeodeziyaYur(geodeziyaYur);
        } else {
            this.geodeziyaServiceYur.updateGeodeziyaYur(geodeziyaYur);
        }

        return "redirect:/addgeoyur";
    }

    @RequestMapping("/removegeo/{id}")
    public String removeGeo(@PathVariable("id") int id) {
        this.geodeziyaService.removeGeodeziya(id);
        return "redirect:/addgeo";
    }

    @RequestMapping("editgeo/{id}")
    public String editGeo(@PathVariable("id") int id, Model model) {
        model.addAttribute("geodeziya", this.geodeziyaService.getGeodeziyaById(id));
        model.addAttribute("listGeodeziya", this.geodeziyaService.listGeodeziya());

        return "addgeo";
    }
    @RequestMapping("/removegeoyur/{id}")
    public String removeGeoYur(@PathVariable("id") int id) {
        this.geodeziyaServiceYur.removeGeodeziyaYur(id);
        return "redirect:/addgeoyur";
    }

    @RequestMapping("editgeoyur/{id}")
    public String editGeoYur(@PathVariable("id") int id, Model model) {
        model.addAttribute("geodeziyaYur", this.geodeziyaServiceYur.getGeodeziyaYurById(id));
        model.addAttribute("listGeodeziyaYur", this.geodeziyaServiceYur.listGeodeziyaYur());

        return "addgeoyur";
    }

    @RequestMapping(value = "addgeoword/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public String addGeoWord(@PathVariable("id") int id, Model model) throws IOException, Docx4JException {


        String userHomeDir = System.getProperty("user.home", ".");
        // String systemDir = userHomeDir + "/.collection";
        //System.out.println(systemDir);


        String filePathOut = System.getProperty("java.io.tmpdir") + "/geodeziya.docx";
        //String filePathOut = userHomeDir + "/proekt-dogovora1.docx";
        //String filePathOut = "D:/proekt-dogovora1.docx";
        //create docx
        CreateWord4j createWord4j = new CreateWord4j();
        String filePath1 = this.getClass().getClassLoader().getResource("1.txt").toString();

        // String filePath = this.getClass().getClassLoader().getResource("proekt-dogovora.txt").toString();
        InputStream filePath = this.getClass().getClassLoader().getResourceAsStream("geodeziya.docx");
        // filePath = filePath.replace("file:/", "");
        System.out.println(filePath);

        // System.out.println(userHomeDir);
        /* final String filePath = "https:\\\\s3.us-east-2.amazonaws.com/elasticbeanstalk-us-east-2-938128964000/proekt-dogovora.docx";
         */
        WordprocessingMLPackage template = createWord4j.getTemplate(filePath);
        //WordprocessingMLPackage template = createWord4j.getTemplate("D:/proekt-dogovora.docx");
        // System.out.println("do " + template);
        Geodeziya geodeziya = this.geodeziyaService.getGeodeziyaById(id);
        RussianDate russianDate = new RussianDate();

        String dateDogovor = russianDate.russianDateFormat(geodeziya.getDataDogovara());
        String dateAct = russianDate.russianDateFormat(geodeziya.getDataAct());
        String rekvizity = "паспорт серии " + geodeziya.getPassportSeriya() + " № " + geodeziya.getPassportNomer() + ", выдан " + geodeziya.getKemVydan() + " " + geodeziya.getKogdaVydan() + "г, проживающий по адресу " + geodeziya.getNaselPunkt() + ", ул. " + geodeziya.getUlica() + ", д." + geodeziya.getDom();
        System.out.println("корпус=" + geodeziya.getKorpus());
        if (geodeziya.getKorpus().length() > 0) {
            rekvizity += ", к." + geodeziya.getKorpus();
        }
        if (geodeziya.getKvartira() != null) {
            rekvizity += ", кв. " + geodeziya.getKvartira();
        }
        if (geodeziya.getTelephone() != null) {
            rekvizity += ", тел. " + geodeziya.getTelephone();
        }
        createWord4j.replacePlaceholder(template, rekvizity, "rekvizity");
        createWord4j.replacePlaceholder(template, geodeziya.getFio(), "fio");
        String placeholder = "nomerDogovara";
        String toAdd = geodeziya.getNomerDogovara();
        createWord4j.replacePlaceholder(template, toAdd, placeholder);
        createWord4j.replacePlaceholder(template, geodeziya.getNameObject(), "nameObject");

        createWord4j.replacePlaceholder(template, dateDogovor, "dataDogovara");
        createWord4j.replacePlaceholder(template, dateAct, "dateAct");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziya.getPolevoiTarif()), "ptarif");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziya.getObem()), "obem");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziya.getKoefPerescheta()), "koef");
        double pcena = (double) Math.round(geodeziya.getPolevoiTarif() * geodeziya.getObem() * 1.5 * 100) / 100;
        double zimnUdorozhanie = (double) Math.round(pcena*geodeziya.getZimnUdorozhanie()*100) / 100;
        double kcena = (double) Math.round(geodeziya.getKamerTarif() * geodeziya.getObem() * 1.4 * 100) / 100;
        double trcena = (double) Math.round(zimnUdorozhanie * geodeziya.getTransportnye()) / 100;
        double orgcena = (double) Math.round(zimnUdorozhanie * 6 / 100 * 1.9 * 100) / 100;
        double itogotec = (double) Math.round((zimnUdorozhanie + kcena + trcena + orgcena) * 100) / 100;
        double itogoper = (double) Math.round(itogotec * geodeziya.getKoefPerescheta() * 100) / 100;
        double nalog = (double) Math.round(itogoper / 95 * 100 * 0.05 * 100) / 100;
        double summVsego = (double) Math.round((itogoper + nalog) * 100) / 100;
        MoneyPropis stoimostPropis = new MoneyPropis(summVsego);
        createWord4j.replacePlaceholder(template, Double.toString(pcena), "pcena");
        createWord4j.replacePlaceholder(template, Double.toString(zimnUdorozhanie), "zimCena");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziya.getZimnUdorozhanie()), "kzimUd");
        createWord4j.replacePlaceholder(template, Double.toString(kcena), "kcena");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziya.getKamerTarif()), "ktarif");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziya.getTransportnye()), "trrash");
        createWord4j.replacePlaceholder(template, Double.toString(trcena), "trcena");
        createWord4j.replacePlaceholder(template, Double.toString(orgcena), "orgcena");
        createWord4j.replacePlaceholder(template, Double.toString(itogotec), "itogotec");
        createWord4j.replacePlaceholder(template, Double.toString(itogoper), "itogoper");
        createWord4j.replacePlaceholder(template, Double.toString(nalog), "nalog");
        createWord4j.replacePlaceholder(template, Double.toString(summVsego), "sumVsego");
        createWord4j.replacePlaceholder(template, stoimostPropis.num2str(), "stoimostPropis");



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
        return "docx/geodeziya";
    }

    @RequestMapping(value = "addgeowordyur/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public String addGeoWordYur(@PathVariable("id") int id, Model model) throws IOException, Docx4JException {


        String userHomeDir = System.getProperty("user.home", ".");
        // String systemDir = userHomeDir + "/.collection";
        //System.out.println(systemDir);


        String filePathOut = System.getProperty("java.io.tmpdir") + "/geoyur.docx";

        CreateWord4j createWord4j = new CreateWord4j();
        String filePath1 = this.getClass().getClassLoader().getResource("1.txt").toString();

        // String filePath = this.getClass().getClassLoader().getResource("proekt-dogovora.txt").toString();
        InputStream filePath = this.getClass().getClassLoader().getResourceAsStream("geoyur.docx");
        // filePath = filePath.replace("file:/", "");
        System.out.println(filePath);

        // System.out.println(userHomeDir);
        /* final String filePath = "https:\\\\s3.us-east-2.amazonaws.com/elasticbeanstalk-us-east-2-938128964000/proekt-dogovora.docx";
         */
        WordprocessingMLPackage template = createWord4j.getTemplate(filePath);
        //WordprocessingMLPackage template = createWord4j.getTemplate("D:/proekt-dogovora.docx");
        // System.out.println("do " + template);
        GeodeziyaYur geodeziyaYur = this.geodeziyaServiceYur.getGeodeziyaYurById(id);
        RussianDate russianDate = new RussianDate();

        String dateDogovor = russianDate.russianDateFormat(geodeziyaYur.getDataDogovara());
        String dateAct = russianDate.russianDateFormat(geodeziyaYur.getDataAct());
        String rekvizity = geodeziyaYur.getRekvizity().getRekvizitOrganization();
        createWord4j.replacePlaceholder(template, rekvizity, "rekvizity");
        createWord4j.replacePlaceholder(template, geodeziyaYur.getRekvizity().getNameOrganization(), "nameZakazchik");
        createWord4j.replacePlaceholder(template, geodeziyaYur.getRekvizity().getPositionRodPadezh(), "dolzhnostRod");
        createWord4j.replacePlaceholder(template, geodeziyaYur.getRekvizity().getFullNameRodPadezh(), "fioRod");
        createWord4j.replacePlaceholder(template, geodeziyaYur.getRekvizity().getPosition(), "DolzhnostIm");
        createWord4j.replacePlaceholder(template, geodeziyaYur.getRekvizity().getFullName(), "fioIm");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziyaYur.getKoefPerescheta()), "koef");
        createWord4j.replacePlaceholder(template, Integer.toString(geodeziyaYur.getSrok()), "srVyp");
        String placeholder = "nomerDogovara";
        String toAdd = geodeziyaYur.getNomerDogovara();
        createWord4j.replacePlaceholder(template, toAdd, placeholder);
        createWord4j.replacePlaceholder(template, geodeziyaYur.getNameObject(), "nameObject");

        createWord4j.replacePlaceholder(template, dateDogovor, "dataDogovara");
        createWord4j.replacePlaceholder(template, dateAct, "dateAct");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziyaYur.getPolevoiTarif()), "ptarif");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziyaYur.getObem()), "obem");

        double pcena = (double) Math.round(geodeziyaYur.getPolevoiTarif() * geodeziyaYur.getObem() * 1.5 * 100) / 100;
        double zimnUdorozhanie = (double) Math.round(pcena*geodeziyaYur.getZimnUdorozhanie()*100) / 100;
        double kcena = (double) Math.round(geodeziyaYur.getKamerTarif() * geodeziyaYur.getObem() * 1.4 * 100) / 100;
        double trcena = (double) Math.round(zimnUdorozhanie * geodeziyaYur.getTransportnye()) / 100;
        double orgcena = (double) Math.round(zimnUdorozhanie * 6 / 100 * 1.9 * 100) / 100;
        double itogotec = (double) Math.round((zimnUdorozhanie + kcena + trcena + orgcena) * 100) / 100;
        double itogoper = (double) Math.round(itogotec * geodeziyaYur.getKoefPerescheta() * 100) / 100;
        double nalog = (double) Math.round(itogoper / 95 * 100 * 0.05 * 100) / 100;
        double summVsego = (double) Math.round((itogoper + nalog) * 100) / 100;
        MoneyPropis stoimostPropis = new MoneyPropis(summVsego);
        createWord4j.replacePlaceholder(template, Double.toString(pcena), "pcena");
        createWord4j.replacePlaceholder(template, Double.toString(zimnUdorozhanie), "zimCena");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziyaYur.getZimnUdorozhanie()), "kzimUd");
        createWord4j.replacePlaceholder(template, Double.toString(kcena), "kcena");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziyaYur.getKamerTarif()), "ktarif");
        createWord4j.replacePlaceholder(template, Double.toString(geodeziyaYur.getTransportnye()), "trrash");
        createWord4j.replacePlaceholder(template, Double.toString(trcena), "trcena");
        createWord4j.replacePlaceholder(template, Double.toString(orgcena), "orgcena");
        createWord4j.replacePlaceholder(template, Double.toString(itogotec), "itogotec");
        createWord4j.replacePlaceholder(template, Double.toString(itogoper), "itogoper");
        createWord4j.replacePlaceholder(template, Double.toString(nalog), "nalog");
        createWord4j.replacePlaceholder(template, Double.toString(summVsego), "sumVsego");
        createWord4j.replacePlaceholder(template, stoimostPropis.num2str(), "stoimostPropis");


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
        return "docx/geodeziya";
    }
}
