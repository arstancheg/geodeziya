package organizaciitelefony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import organizaciitelefony.calculation.NZTR;
import organizaciitelefony.model.Smety;
import organizaciitelefony.model.ZadanieNaProekt;
import organizaciitelefony.service.NztNormService;
import organizaciitelefony.service.RekvizityServise;
import organizaciitelefony.service.ZadanieNaProektService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class ZadanieNaProect {
    @Autowired
    private ZadanieNaProektService zadanieNaProektService;
    @Autowired
    private RekvizityServise rekvizityServise;
    @RequestMapping(value = "zadanienaproekt", method = RequestMethod.GET)
    public String ishdannye(Model model) {
        // model.addAttribute("rekvizity", new Rekvizity());
        return "zadanienaproekt";
    }

    @RequestMapping(value = "/savezadanie", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody()
    public int saveZadanie(@RequestBody Map<String, String> map) throws Exception {
        ZadanieNaProekt zadanieNaProekt=new ZadanieNaProekt();
        zadanieNaProekt.setNameObject(map.get("nameObject"));
//        System.out.println("nameObject="+map.get("nameObject"));
        zadanieNaProekt.setTableZadanie(map.get("ZadanieTable"));
//        System.out.println("ZadanieTable="+map.get("ZadanieTable"));


        DateFormat dateBegin = new SimpleDateFormat("yyyy-MM-dd");
//        smety.setDateBegin(new java.sql.Date(dateBegin.parse(map.get("dateBegin")).getTime()));
        int idZakazchik = Integer.parseInt(map.get("idZakazchik"));
        int idSmeta = Integer.parseInt(map.get("idZadanie"));

//        zadanieNaProekt.setRekvizity(this.rekvizityServise.getOrganizationById(idZakazchik));
        if (idSmeta > 0) {
            zadanieNaProekt.setId(idSmeta);
            this.zadanieNaProektService.updateZadanie(zadanieNaProekt);
        } else {
            this.zadanieNaProektService.addZadanie(zadanieNaProekt);
        }
        int id = zadanieNaProekt.getId();
        System.out.println("id=" + id);


        return id;
    }
    @RequestMapping("editzadanie/{id}")
    public String editZadanie(@PathVariable("id") int id, Model model) {
        model.addAttribute("zadanie", this.zadanieNaProektService.getZadanieById(id));


        return "zadanienaproekt";
    }

    @RequestMapping(value = "zadaniyaspisok", method = RequestMethod.GET)
    public String listZadaniya(Model model) {
        model.addAttribute("zadaniya", new ZadanieNaProect());
        model.addAttribute("listZadaniya", this.zadanieNaProektService.listZadanie());

        return "zadaniyaspisok";
    }

    @RequestMapping("/removezadanie/{id}")
    public String removeZadanie(@PathVariable("id") int id) {
        this.zadanieNaProektService.removeZadanie(id);
        return "redirect:/zadaniyaspisok";
    }

    @RequestMapping("/copyzadanie/{id}")
    public String copyZadanie(@PathVariable("id") int id) {

       ZadanieNaProekt oldZadanieNaProekt=this.zadanieNaProektService.getZadanieById(id);
        System.out.println("id проекта="+oldZadanieNaProekt.getId());
        System.out.println("Название="+oldZadanieNaProekt.getNameObject());
        System.out.println("Таблица = "+oldZadanieNaProekt.getTableZadanie());

       ZadanieNaProekt newZadanieNaProekt=new ZadanieNaProekt();
       newZadanieNaProekt.setTableZadanie(oldZadanieNaProekt.getTableZadanie());
       newZadanieNaProekt.setNameObject(oldZadanieNaProekt.getNameObject());
      this.zadanieNaProektService.addZadanie(newZadanieNaProekt);
        return "redirect:/zadaniyaspisok";
    }
}
