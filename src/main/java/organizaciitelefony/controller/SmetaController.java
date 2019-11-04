package organizaciitelefony.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.bcel.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import organizaciitelefony.calculation.OtherTableNzt;
import organizaciitelefony.calculation.NZTR;
import organizaciitelefony.model.*;
import organizaciitelefony.russiandate.MoneyPropis;
import organizaciitelefony.service.*;
import organizaciitelefony.word.ConvertTableToWord;
import organizaciitelefony.word.CreateTable;
import organizaciitelefony.word.CreateTableMerge;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Controller
public class SmetaController {
    @Autowired
    private RekvizityServise rekvizityServise;
    @Autowired
    private DogovorService dogovorService;
    @Autowired
    private NztService nztService;
    @Autowired
    private NztTableService nztTableService;
    @Autowired
    private NztNormService nztNormService;
    @Autowired
    private Nzt20PrilozhenieAService nzt20PrilozhenieAService;
    @Autowired
    private SmetyService smetyService;

    @RequestMapping(value = "smeta", method = RequestMethod.GET)
    public String listNzt(Model model) throws Exception {
        /*CreateTable createTable=new CreateTable();
        createTable.createSimpleTable();*/
        /*CreateTableMerge createTableMerge= new CreateTableMerge();
        createTableMerge.createWordMerge();*/

        OtherTableNzt otherTableNzt = new OtherTableNzt();
        String dop = otherTableNzt.dopProectnyeRaboty();
        model.addAttribute("smeta", new Nzt());
        model.addAttribute("listNzt", this.nztService.listNzt());
        model.addAttribute("dop", dop);
        List<Nzt> match = this.nztService.listNzt();
        // model.addAttribute("rekvizity", new Rekvizity());
        //  model.addAttribute("listOrganization", this.rekvizityServise.listOrganization());
     /*   for (Dogovor s : match) {
            System.out.println(s.getId());
            System.out.println(s.getFullName());
            System.out.println(s.getRekvizity());
        }*/
       /* double nztMin = 59;
        double nztMax = 110;
        double valueObject = 700;
        double valueNaturalObjectMin = 500;
        double valueNaturalObjectMax = 1000;
        NZTR nztr = new NZTR();
        System.out.println("привет");
        System.out.println(nztr.nztInInterval(nztMin, nztMax, valueObject, valueNaturalObjectMin, valueNaturalObjectMax));
*/
        return "smeta";
    }

    @RequestMapping(value = "searchNztTable", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody()
    public String searchNztTable(HttpServletRequest request) {
        System.out.println(request.getParameter("tableId"));

        // именно здесь String преобразуется в int
        int nztId = Integer.parseInt(request.getParameter("tableId").trim());

        // выведем на экран значение после конвертации
        System.out.println("int i = " + nztId);

        /*int nztId=(int) request.getParameter("tableId");*/
        String selectNztTable = "<p>Выберите таблицу</p><p><select name=\"nztTable\" id=\"nztTableId\" onchange=\"getNztNorm();\">";
        List<NztTable> match = this.nztTableService.findByNztId(nztId);
        for (NztTable r : match) {
            selectNztTable += "<option value=\"" + r.getId() + "\">" + r.getNztTableNumber() + " " + r.getNztTableName() + "</option>";
        }
        selectNztTable += "</select></p>";

        return selectNztTable;
    }

    @RequestMapping(value = "searchnztnorm", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody()
    public String searchNztNormByIdTable(HttpServletRequest request) {
        System.out.println(request.getParameter("tableId"));

        // именно здесь String преобразуется в int
        int nztTableId = Integer.parseInt(request.getParameter("tableId").trim());

        // выведем на экран значение после конвертации
        System.out.println("int i = " + nztTableId);

        /*int nztId=(int) request.getParameter("tableId");*/
        String selectNztNormObject = "<p>Выберите наименование</p><p><select name=\"nztNorm\" id=\"nztNorm\" ><option></option>";
        List<String> match = this.nztNormService.findByTableId(nztTableId);
        for (String r : match) {
            selectNztNormObject += "<option value=\"" + r + "\">" + r + "</option>";
        }
        selectNztNormObject += "</select></p>";

        return selectNztNormObject;
    }

    @RequestMapping(value = "smetaResult", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody()
    public String smetaResult(HttpServletRequest request) {
        System.out.println("tableId=" + request.getParameter("tableId"));
        System.out.println("NormName=" + request.getParameter("NormName"));
        System.out.println("valueNormObject=" + request.getParameter("valueNormObject"));
        System.out.println("koefVidStroitelstva=" + request.getParameter("koefVidStroitelstva"));
        System.out.println("paralProkladka=" + request.getParameter("paralProkladka"));
        int vidZdaniya = Integer.parseInt(request.getParameter("vidZdaniya").trim());
        String withRaspredelenie = request.getParameter("withRaspredelenie");
        //преобразуем дату в месяц.год
        System.out.println("dateBegin" + request.getParameter("dateBegin"));
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date parsingDate = null;
        try {
            parsingDate = ft.parse(request.getParameter("dateBegin"));
            System.out.println(parsingDate);
        } catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + ft);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("M.yyyy");
        String dateBeginStr = dateFormat.format(parsingDate);
        double dateBegin = Double.parseDouble(dateBeginStr);
        System.out.println("Дата" + dateBegin);

        NZTR nztr = new NZTR();
        OtherTableNzt otherTableNzt = new OtherTableNzt();

        double Vr = (double) Math.round(otherTableNzt.getVr(dateBegin) * 100) / 100;
        System.out.println("Вр" + Vr);
        String raspredelenieZatrat = " ";
        double koefficientTarifPereschet = 0;
        double normaZatratTrudovyhResursov = 0;
        double itogoTrudozatrat = 0;
        double valueNormObject = Double.parseDouble(request.getParameter("valueNormObject"));
        double koefVidStroitelstva = Double.parseDouble(request.getParameter("koefVidStroitelstva"));
        String normaZatratTrudovyhResursovFormula = "";
        String raschet = "";
        int nztIdTable = Integer.parseInt(request.getParameter("tableId").trim());
        int paralelProkladka = Integer.parseInt(request.getParameter("paralProkladka").trim());
        String normName = request.getParameter("NormName");
        List<NZTNorm> listNzt = this.nztNormService.findNztNormByNameAndIdTable(nztIdTable, normName);
        System.out.println(listNzt.size());
        System.out.println("первый" + listNzt.get(0).getNormaZatrat());
        System.out.println("последний" + listNzt.get(listNzt.size() - 1).getNormaZatrat());
        //нахоим количество строк в таблице
        int listNztSize = listNzt.size();
        //если строк больше чем одна находим максимальное и минимальное значение натурального показателя объекта
        if (listNztSize > 1) {
            double minValueObject = listNzt.get(0).getValueNaturalObject();
            double maxValueObject = listNzt.get(listNzt.size() - 1).getValueNaturalObject();
            //Если значение показателя объекта меньше минимального, то считаем по первой формуле
            if (valueNormObject < minValueObject) {
                koefficientTarifPereschet = otherTableNzt.getKoefficientTarif(listNzt.get(0).getRazryadSlozhnosti());
                double nztMin = listNzt.get(0).getNormaZatrat();
                double nztMinNext = listNzt.get(1).getNormaZatrat();
                double valueObject = valueNormObject;
                double valueNaturalObjectMin = minValueObject;
                double valueNaturalObjectMinNext = listNzt.get(1).getValueNaturalObject();
                normaZatratTrudovyhResursov = nztr.nztLessMinimum(nztMin, nztMinNext, valueObject, valueNaturalObjectMin, valueNaturalObjectMinNext);
                normaZatratTrudovyhResursovFormula = nztr.nztLessMinimumFormula(nztMin, nztMinNext, valueObject, valueNaturalObjectMin, valueNaturalObjectMinNext);
            }
            //если значение показателя объекта больше максимального, то считаем по второй формуле NZTR
            else if (valueNormObject > maxValueObject) {
                koefficientTarifPereschet = otherTableNzt.getKoefficientTarif(listNzt.get(listNzt.size() - 1).getRazryadSlozhnosti());
                double nztMax = listNzt.get(listNzt.size() - 1).getNormaZatrat();
                double nztMaxPrev = listNzt.get(listNzt.size() - 2).getNormaZatrat();
                double valueObject = valueNormObject;
                double valueNaturalObjectMax = listNzt.get(listNzt.size() - 1).getValueNaturalObject();
                double valueNaturalObjectMaxPrev = listNzt.get(listNzt.size() - 2).getValueNaturalObject();
                normaZatratTrudovyhResursov = nztr.nztMoreMax(nztMax, nztMaxPrev, valueObject, valueNaturalObjectMax, valueNaturalObjectMaxPrev);
                normaZatratTrudovyhResursovFormula = nztr.nztMoreMaxFormula(nztMax, nztMaxPrev, valueObject, valueNaturalObjectMax, valueNaturalObjectMaxPrev);
            }
            //если значение находится в интервали, то находим нужный интервал и считаем по третьей формуле NZTR
            else {
                int n = 0;
                //если значение находится в интервале то interval= 1, иначе 0
                int interval = 1;
                for (int i = 0; i < listNztSize; i++) {
                    n = i;
                    if (valueNormObject > listNzt.get(i).getValueNaturalObject() && valueNormObject < listNzt.get(i + 1).getValueNaturalObject())
                        break;
                    if (valueNormObject == listNzt.get(i).getValueNaturalObject()) {
                        interval = 0;
                        break;
                    }
                }
                if (interval != 0) {
                    koefficientTarifPereschet = otherTableNzt.getKoefficientTarif(listNzt.get(n + 1).getRazryadSlozhnosti());

                    double nztMin = listNzt.get(n).getNormaZatrat();
                    double nztMax = listNzt.get(n + 1).getNormaZatrat();
                    double valueObject = valueNormObject;
                    double valueNaturalObjectMin = listNzt.get(n).getValueNaturalObject();
                    double valueNaturalObjectMax = listNzt.get(n + 1).getValueNaturalObject();
                    normaZatratTrudovyhResursov = nztr.nztInInterval(nztMin, nztMax, valueObject, valueNaturalObjectMin, valueNaturalObjectMax);
                    normaZatratTrudovyhResursovFormula = nztr.nztInIntervalFormula(nztMin, nztMax, valueObject, valueNaturalObjectMin, valueNaturalObjectMax);
                } else {
                    koefficientTarifPereschet = otherTableNzt.getKoefficientTarif(listNzt.get(n).getRazryadSlozhnosti());
                    normaZatratTrudovyhResursov = listNzt.get(n).getNormaZatrat();
                    normaZatratTrudovyhResursovFormula = String.valueOf(normaZatratTrudovyhResursov);
                }

            }
        }
        String obosnovanie = "СНЗТ\n" + listNzt.get(0).getNzt().getNztNumber() + " т. " + listNzt.get(0).getNztTable().getNztTableNumber() + " к.= " + koefVidStroitelstva;
        itogoTrudozatrat = (double) Math.round(normaZatratTrudovyhResursov * koefficientTarifPereschet * koefVidStroitelstva * 100) / 100;
        /*raschet += "Норма затрат трудовых ресурсов =" + normaZatratTrudovyhResursov + "" +
                "<br> Тарифный коэффициент = " + koefficientTarifPereschet +
                "<br> Коэффицинет = " + koefVidStroitelstva +
                "<br> Итого трудозатрат: " + itogoTrudozatrat + " ч/дней" +

                "</div>";*/
        raschet += "<tbody id=\"nzt\"><tr>" +
                "    <td style=\"border: 1px solid black;\">№ п.п.</td>" +
                "    <td style=\"border: 1px solid black;\">Наименование    видов работ</td>" +
                "    <td style=\"border: 1px solid black;\">Обоснование</td>" +
                "    <td colspan=\"2\" style=\"border: 1px solid black;\">Расчет</td>" +
                "    <td style=\"border: 1px solid black;\">Итого трудозатрат</td>" +
                "    <td style=\"border: 1px solid black;\">Отношение к 14р</td>" +
                "    <td style=\"border: 1px solid black;\">Коэффициенты</td>" +
                "    <td style=\"border: 1px solid black;\">Итого:</td>" +
                "    <td style=\"border: 1px solid black;\">Примечание</td>" +
                "    <td  rowspan=\"2\"><input type=\"button\" value=\"Удалить\" id=\"delTBody\" ></td>" +
                "  </tr>" +
                "  <tr>" +
                "    <td style=\"border: 1px solid black;\" class=\"nomerPP\"></td>" +
                "    <td style=\"border: 1px solid black;\" class=\"vidRabot\" data-vidZdaniya=\"" + vidZdaniya + "\" data-raspredelenie=\"" + withRaspredelenie + "\" data-idTable=\"" + nztIdTable + "\">" + normName + ",<input class=\"inpValueNormObject\" value=\"" + valueNormObject + "\"></td>" +
                "    <td style=\"border: 1px solid black;\" class=\"tdObosnovanie\">" + obosnovanie + "</td>" +
                "    <td colspan=\"2\" style=\"border: 1px solid black;\" class=\"tdRsachet\" >" + normaZatratTrudovyhResursovFormula + "</td>" +
                "    <td align=\"center\" style=\"border: 1px solid black;\" class=\"tdTrudozatraty\">" + normaZatratTrudovyhResursov + "</td>" +
                "    <td align=\"center\" style=\"border: 1px solid black;\">" + koefficientTarifPereschet + "</td>" +
                "    <td align=\"center\" style=\"border: 1px solid black;\" class=\"koefVidStroitelstva\">" + koefVidStroitelstva + "</td>" +
                "    <td align=\"center\" id=\"itogoTrudozatrat\" style=\"border: 1px solid black;\" class=\"tdItogoTrudozatrat\">" + itogoTrudozatrat + "</td>" +
                "    <td align=\"center\" style=\"border: 1px solid black;\">ч/дней</td>" +
                " </tr> ";
        //параллельная прокладка
        if (paralelProkladka == 1) {
            String tbodyParProkladka = "<tr>" +
                    "    <td style=\"border: 1px solid black;\" class=\"nomerPP\"></td>" +
                    "    <td style=\"border: 1px solid black;\">Параллельная прокладка</td>" +
                    "    <td style=\"border: 1px solid black;\">СНЗТ 8.02.22-2014 т. 7.1 к=0,7</td>" +
                    "    <td colspan=\"2\" style=\"border: 1px solid black;\" >Н.З.=" + itogoTrudozatrat + "*0,7</td>" +
                    "    <td align=\"center\" style=\"border: 1px solid black;\">" + itogoTrudozatrat * 0.7 + "</td>" +
                    "    <td align=\"center\" style=\"border: 1px solid black;\"> - </td>" +
                    "    <td align=\"center\" style=\"border: 1px solid black;\"> - </td>" +
                    "    <td align=\"center\" id=\"itogoTrudozatrat\" style=\"border: 1px solid black;\">" + itogoTrudozatrat * 0.7 + "</td>" +
                    "    <td align=\"center\" style=\"border: 1px solid black;\">ч/дней</td>" +
                    "    <td> </td>" +
                    " </tr> ";
            raschet += tbodyParProkladka;
        }
       /* int vidZdaniya = Integer.parseInt(request.getParameter("vidZdaniya").trim());
        String withRaspredelenie = request.getParameter("withRaspredelenie");*/
        System.out.println(withRaspredelenie);
        //распределение трудовых затрат по приложению A СНЗТ 20
//        if ((listNzt.get(0).getNztTable().getId() > 20) && (listNzt.get(0).getNztTable().getId() < 30)) {
        if (withRaspredelenie.equals("yes")) {
            int kol = 0;
            int vidZdaniyaId = vidZdaniya;
            System.out.println("vidZdaniya=" + vidZdaniyaId);


            raspredelenieZatrat += "<tr>" +
                    "    <td style=\"border: 1px solid black;\"></td>" +
                    "    <td colspan=\"9\" align=\"center\" style=\"border: 1px solid black;\">Распределение    по разделам проектирования</td>" +
                    "    <td style=\"border: 1px solid black;\"></td>" +
                    "  </tr>";
            raspredelenieZatrat += " <tr>" +
                    "    <td style=\"border: 1px solid black;\"></td>" +
                    "    <td style=\"border: 1px solid black;\">Наименование    видов работ</td>" +
                    "    <td style=\"border: 1px solid black;\">Обоснование</td>" +
                    "    <td colspan=\"2\" style=\"border: 1px solid black;\">Норма затрат трудовых ресурсов</td>" +
                    "    <td colspan=\"3\" style=\"border: 1px solid black;\">Фактические затраты трудовых ресурсов</td>" +
                    "    <td style=\"border: 1px solid black;\">Итого:</td>" +
                    "    <td style=\"border: 1px solid black;\">Примечание</td>" +
                    "    <td></td>" +
                    "  </tr>";
            for (Nzt20PrilozhenieA nztA : this.nzt20PrilozhenieAService.findByIdVidzdaniyaInPrilozhenieA(vidZdaniyaId)
            ) {

                raspredelenieZatrat += " <tr>" +
                        "    <td style=\"border: 1px solid black;\" class=\"nomerPPpod\"></td>" +
                        "    <td style=\"border: 1px solid black;\">" + nztA.getRazdelDokumentacii() + "</td>" +
                        "    <td style=\"border: 1px solid black;\">Приложение А2 СНЗТ 20-2014</td>" +
                        "    <td align=\"center\" colspan=\"2\" style=\"border: 1px solid black;\">" + nztA.getProcent() + "%</td>" +
                        "    <td align=\"center\" colspan=\"3\" style=\"border: 1px solid black;\"><input class=\"valueRaspredelenie\"  style=\"width: 50px;\" type=\"text\" name=\"valueRaspredelenie\" id=\"valueRaspredelenie" + kol + "\" >%</td>" +
                        "    <td align=\"center\" class=\"valueRaspredelenieItogo\" style=\"border: 1px solid black;\"></td>" +
                        "    <td style=\"border: 1px solid black;\">ч/дней</td>" +
                        "    <td></td>" +
                        "  </tr>";
                /*raspredelenieZatrat += "<tr><td>" + nztA.getRazdelDokumentacii() + "</td><td>" + nztA.getProcent() + "%</td><td><input onchange=\"raspredelenie();\" style=\"width: 50px;\" type=\"text\" name=\"valueRaspedelenie\" id=\"valueRaspedelenie" + kol +
                        "\" >%</td><td><span id=\"valueRaspedelenieItogo" + kol + "\"></span></td><td>ч/дней</td></tr>";
               */
                kol++;
            }
            raspredelenieZatrat += "  <tr>" +
                    "    <td style=\"border: 1px solid black;\"></td>" +
                    "    <td colspan=\"7\" align=\"right\" style=\"border: 1px solid black;\">Итого трудозатрат:</td>" +
                    "    <td id=\"itogoRaspredelenoeZatrat\" style=\"border: 1px solid black;\"></td>" +
                    "    <td style=\"border: 1px solid black;\">ч/дней</td>\n" +
                    "    <td></td>" +
                    "  </tr>";
            raspredelenieZatrat += " <tr>" +
                    "    <td style=\"border: 1px solid black;\"></td>" +
                    "    <td colspan=\"7\" align=\"right\" style=\"border: 1px solid black;\">Вр=</td>" +
                    "    <td id=\"vr\" class=\"vr\" style=\"border: 1px solid black;\">" + Vr + "</td>" +
                    "    <td style=\"border: 1px solid black;\">рублей</td>" +
                    "    <td></td>" +
                    "  </tr>";
            raspredelenieZatrat += "  <tr>" +
                    "    <td style=\"border: 1px solid black;\"></td>" +
                    "    <td colspan=\"4\" align=\"right\" style=\"border: 1px solid black;\">ИТОГО стоимость:</td>" +
                    "    <td colspan=\"3\" align=\"center\" id=\"stoimostPSDFormula\" style=\"border: 1px solid black;\"></td>" +
                    "    <td align=\"left\" id=\"stoimostPSD\" style=\"border: 1px solid black;\"></td>" +
                    "    <td style=\"border: 1px solid black;\">рублей</td>" +
                    "    <td></td>" +
                    "  </tr></tbody>";
            //   raspredelenieZatrat += "<tr><td colspan=\"3\" style=\"text-align: right; font-weight: bold;\" >Итого трудозатрат по капитальному ремонту здания:</td><td id=\"itogoRaspredelenoeZatrat\"></td><td>ч/дней</td></tr>";
            //   raspredelenieZatrat += "<tr><td colspan=\"3\" style=\"text-align: right; font-weight: bold;\" >Вр=</td><td id=\"vr\">" + Vr + "</td><td>рублей</td></tr>";
            // raspredelenieZatrat += "<tr><td style=\"text-align: right; font-weight: bold;\" >Итого стоимость разработки ПСД:</td><td id=\"stoimostPSDFormula\" colspan=\"2\"></td><td id=\"stoimostPSD\"></td><td>рублей</td></tr>";

        } else {
            String stoimostPSDFormula = Vr + "*" + itogoTrudozatrat + "=";
            double stoimostPSD = (double) Math.round(Vr * itogoTrudozatrat * 100) / 100;
            raspredelenieZatrat += " <tr>" +
                    "    <td style=\"border: 1px solid black;\"></td>" +
                    "    <td colspan=\"7\" align=\"right\" style=\"border: 1px solid black;\">Вр=</td>" +
                    "    <td id=\"vr\" class=\"vr\" style=\"border: 1px solid black;\">" + Vr + "</td>" +
                    "    <td style=\"border: 1px solid black;\">рублей</td>" +
                    "    <td></td>" +
                    "  </tr>";
            if (paralelProkladka == 1) {
                raspredelenieZatrat += "  <tr>" +
                        "    <td style=\"border: 1px solid black;\"></td>" +
                        "    <td colspan=\"4\" align=\"right\" style=\"border: 1px solid black;\">ИТОГО стоимость:</td>" +
                        "    <td colspan=\"3\" align=\"center\" id=\"stoimostPSDFormula\" style=\"border: 1px solid black;\">" + Vr + "* (" + itogoTrudozatrat + " + " + itogoTrudozatrat * 0.7 + ")=</td>" +
                        "    <td align=\"left\" id=\"stoimostPSD\" style=\"border: 1px solid black;\">" + stoimostPSD * 1.7 + "</td>" +
                        "    <td style=\"border: 1px solid black;\">рублей</td>" +
                        "    <td></td>" +
                        "  </tr></tbody>";
            } else {
                raspredelenieZatrat += "  <tr>" +
                        "    <td style=\"border: 1px solid black;\"></td>" +
                        "    <td colspan=\"4\" align=\"right\" style=\"border: 1px solid black;\">ИТОГО стоимость:</td>" +
                        "    <td colspan=\"3\" align=\"center\" id=\"stoimostPSDFormula\" style=\"border: 1px solid black;\">" + stoimostPSDFormula + "</td>" +
                        "    <td align=\"left\" id=\"stoimostPSD\" style=\"border: 1px solid black;\">" + stoimostPSD + "</td>" +
                        "    <td style=\"border: 1px solid black;\">рублей</td>" +
                        "    <td></td>" +
                        "  </tr></tbody>";
            }

        }
        raschet += raspredelenieZatrat;
        return raschet;
    }

    @RequestMapping(value = "/smeta/add", method = RequestMethod.GET)
    public String addSmeta(@ModelAttribute("rekvizity") NztNormService nztNormService) {
        /*if (rekvizity.getId() == 0) {
            this.rekvizityServise.addOrganization(rekvizity);
        } else {
            this.rekvizityServise.updateOrganization(rekvizity);
        }*/
        double nztMin = 59;
        double nztMax = 110;
        double valueObject = 700;
        double valueNaturalObjectMin = 500;
        double valueNaturalObjectMax = 1000;
        NZTR nztr = new NZTR();

        System.out.println(nztr.nztInInterval(nztMin, nztMax, valueObject, valueNaturalObjectMin, valueNaturalObjectMax));

        return "redirect:/smeta";
    }

    @RequestMapping(value = "vr", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody()
    public Double Vr(HttpServletRequest request) {


        System.out.println(request.getParameter("dateVr"));
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date parsingDate = null;
        try {
            parsingDate = ft.parse(request.getParameter("dateVr"));
            System.out.println(parsingDate);
        } catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + ft);
        }

        OtherTableNzt otherTableNzt = new OtherTableNzt();

        double Vr = (double) otherTableNzt.getVrFullDate(parsingDate);
        System.out.println("vr=" + Vr);

        return Vr;
    }

    @RequestMapping(value = "valtosrt", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody()
    public String valtosrt(HttpServletRequest request) {

        MoneyPropis moneyPropis = new MoneyPropis(request.getParameter("val"));


        return moneyPropis.num2str();
    }

    @RequestMapping(value = "searchminmaxtable", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody()
    public String searchminmaxtable(HttpServletRequest request) {

        String normName = request.getParameter("nztNorm");
        System.out.println(normName);
        int nztIdTable = Integer.parseInt(request.getParameter("nztIdTable").trim());
        List<NZTNorm> listNzt = this.nztNormService.findNztNormByNameAndIdTable(nztIdTable, normName);

        //нахоим количество строк в таблице
        int listNztSize = listNzt.size();
        String tableMinMax = "<table style=\"width: 800px;\"><tbody>" +
                "<tr>" +
                "<td style=\"width: 80px;\">Идентификатор нормы</td>" +
                "<td>Наименование объекта проектирования</td>" +
                "<td style=\"width: 100px;\">Значение натурального показателя объекта проектирования</td>" +
                "<td style=\"width: 100px;\">Разряд сложности</td>" +
                "<td style=\"width: 100px;\">Норма затрат трудовых ресуроов, чел-дней</td>" +
                "</tr>";
        for (int i = 0; i < listNzt.size(); i++) {
            if (i == 0) {
                tableMinMax = tableMinMax + "<tr>" +
                        "<td>" + listNzt.get(i).getIdNorm() + "</td>" +
                        "<td rowspan=\"" + listNzt.size() + "\">" + listNzt.get(i).getNameObject() + "</td>" +
                        "<td align=\"center\">" + listNzt.get(i).getValueNaturalObject() + "</td>" +
                        "<td align=\"center\">" + listNzt.get(i).getRazryadSlozhnosti() + "</td>" +
                        "<td align=\"center\">" + listNzt.get(i).getNormaZatrat() + "</td></tr>";
            } else {
                tableMinMax = tableMinMax + "<tr>" +
                        "<td>" + listNzt.get(i).getIdNorm() + "</td>" +
                        "<td align=\"center\">" + listNzt.get(i).getValueNaturalObject() + "</td>" +
                        "<td align=\"center\">" + listNzt.get(i).getRazryadSlozhnosti() + "</td>" +
                        "<td align=\"center\">" + listNzt.get(i).getNormaZatrat() + "</td></tr>";

            }
        }
        tableMinMax = tableMinMax + "</tbody></table>";
        return tableMinMax;
    }

    //    @RequestMapping(value = "/smetatabletoword", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @RequestMapping(value = "/smetatabletoword", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
//    @ResponseBody()
    public String smetaToword(Model model, @RequestBody Map<String, String> map) throws Exception {

        String smetaTable = (String) map.get("smetaTable");

//        System.out.println(smetaTable);
        ConvertTableToWord convertTableToWord = new ConvertTableToWord();
        convertTableToWord.convertToWord(smetaTable);


        return "Документ сформирован";
    }

    @RequestMapping(value = "/joinsmeta", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody()
    public String joinSmeta(Model model, @RequestBody Map<String, int[]> map) throws Exception {

        int[] id = (int[]) map.get("id");
        Smety oldSmeta = this.smetyService.getSmetaById(id[0]);
        Smety smety = new Smety();
        smety.setRekvizity(oldSmeta.getRekvizity());
        smety.setNameObject(oldSmeta.getNameObject());
        smety.setNomerSmety(oldSmeta.getNomerSmety());
        smety.setDateBegin(oldSmeta.getDateBegin());
        smety.setPrimechanie(oldSmeta.getPrimechanie());
        smety.setNomerObject(oldSmeta.getNomerObject());
        double oplata = 0;
        String table = "";
        String footer = "";
        Pattern patternOplata = Pattern.compile("( id=\\\"oplata\\\" style=\\\"border: 1px solid black;\\\">)([\\d.]+)(<\\/td>)");

        try {

            Pattern pattern = Pattern.compile("<tbody[\\s\\S]+?<tbody id=\"tbodyItogoKOplate\">[\\s\\S]+?</tbody>");
            Pattern patternFooter = Pattern.compile("<tbody class=\"tableFooter[\\s\\S]+");
            Matcher matcher = pattern.matcher(oldSmeta.getSmetaTable());
            Matcher matcherFooter = patternFooter.matcher((oldSmeta.getSmetaTable()));
            Matcher matcherOplata = patternOplata.matcher(oldSmeta.getSmetaTable());
            int count = 0;
            while (matcher.find()) {

                count++;
                System.out.println("Номер вхождения: " + count);
                System.out.println("Начальная позиция вхождения: " + matcher.start());
                System.out.println("Конечная позиция вхождения: " + matcher.end());
                System.out.println(matcher.group());
                table += matcher.group();

            }
            while (matcherOplata.find()) {

                oplata += Double.parseDouble(matcherOplata.group(2));
                System.out.println(oplata);

            }
            while (matcherFooter.find()) {

                footer = matcherFooter.group();


            }
        } catch (PatternSyntaxException pse) {
            System.err.println("Неправильное регулярное выражение: " + pse.getMessage());
            System.err.println("Описание: " + pse.getDescription());
            System.err.println("Позиция: " + pse.getIndex());
            System.err.println("Неправильный шаблон: " + pse.getPattern());
        }


        if (id.length > 1) {
            Pattern patternCenter = Pattern.compile("(<tbody id=\\\"shapkaTbody\\\">[\\s]+?</tbody>[\\s]+?)(<tbody[\\s\\S]+<tbody id=\"tbodyItogoKOplate\">[\\s\\S]+?</tbody>)");

            for (int i = 1; i < id.length; i++) {
                Matcher matcherCenter = patternCenter.matcher(this.smetyService.getSmetaById(id[i]).getSmetaTable());
                while (matcherCenter.find()) {
                    table += matcherCenter.group(2);
                }
                Matcher matcherOplataC = patternOplata.matcher(this.smetyService.getSmetaById(id[i]).getSmetaTable());
                while (matcherOplataC.find()) {
                    oplata += Double.parseDouble(matcherOplataC.group(2));
                }

            }
        }
        MoneyPropis moneyPropis = new MoneyPropis(oplata);


        String oplataTR = " <tr>\n" +
                "             <td style=\"border: 1px solid black;\"></td>\n" +
                "             <td colspan=\"7\" align=\"right\" style=\"border: 1px solid black;\">Всего стоимость работ:</td>\n" +
                "             <td align=\"right\" id=\"oplataFull\" style=\"border: 1px solid black;\">" + oplata + "</td>\n" +
                "             <td style=\"border: 1px solid black;\">рублей</td>\n" +
                "             <td></td>\n" +
                "         </tr> <tr>\n" +
                "             <td style=\"border: 1px solid black;\"></td>\n" +
                "             <td align=\"right\" style=\"border: 1px solid black;\">Всего к оплате:</td>\n" +
                "             <td colspan=\"8\" id=\"stoimostStr\" style=\"border: 1px solid black;\">" + moneyPropis.num2str() + "</td>\n" +
                "             <td></td>\n" +
                "         </tr>";

        table += oplataTR+footer;
        smety.setSmetaTable(table);
        this.smetyService.addSmeta(smety);
        return "redirect:/smetyspisok";
    }

    @RequestMapping(value = "/saveword", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public String smetaTowordSave(Model model) throws Exception {
        String filePathOut = System.getProperty("java.io.tmpdir") + "/smeta.docx";
        model.addAttribute("filename", filePathOut);
        return "docx/smeta";
    }

    @RequestMapping(value = "searchzakazchik", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String searchzakazchik(HttpServletRequest request) {
        // System.out.println(request.getParameter("nameOrg"));
        int id = 0;
        List<Rekvizity> match = this.rekvizityServise.findByNameOrganization(request.getParameter("nameOrg"));
        String data = "";
        for (Rekvizity r : match) {
            String rek = r.getRekvizitOrganization().replaceAll("\n", " ").replaceAll("\r", "").trim();
            System.out.println(rek);
            data = "{\"rekvizit\": \"" + rek + "\", \"position\": \"" + r.getPosition() + "\", \"name\": \"" + r.getFullName() + "\", \"id\": \"" + r.getId() + "\"}";
        }
        System.out.println(data);
        return data;
    }

    //    var userObj = {"smetaTable": smeta, "idZakazchik":idZakazchik, "nomerSmety":nomerSmety, "nameObject":nameObject   };
    @RequestMapping(value = "/savesmeta", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody()
    public int savesmeta(@RequestBody Map<String, String> map) throws Exception {
        Smety smety = new Smety();
        smety.setNameObject(map.get("nameObject"));
        smety.setNomerSmety(map.get("nomerSmety"));
        smety.setSmetaTable(map.get("smetaTable"));
        smety.setNomerObject(map.get("nomerObject"));
        smety.setPrimechanie(map.get("primechanie"));
        DateFormat dateBegin = new SimpleDateFormat("yyyy-MM-dd");
        smety.setDateBegin(new java.sql.Date(dateBegin.parse(map.get("dateBegin")).getTime()));
        int idZakazchik = Integer.parseInt(map.get("idZakazchik"));
        int idSmeta = Integer.parseInt(map.get("idSmeta"));

        smety.setRekvizity(this.rekvizityServise.getOrganizationById(idZakazchik));
        if (idSmeta > 0) {
            smety.setId(idSmeta);
            this.smetyService.updateSmeta(smety);
        } else {
            this.smetyService.addSmeta(smety);
        }
        int id = smety.getId();
        System.out.println("id=" + id);


        return id;
    }

    @RequestMapping(value = "smetyspisok", method = RequestMethod.GET)
    public String listSmety(Model model) {
        model.addAttribute("smety", new Smety());
        model.addAttribute("listSmety", this.smetyService.listSmety());

        return "smetyspisok";
    }

    @RequestMapping("/removesmeta/{id}")
    public String removeSmeta(@PathVariable("id") int id) {
        this.smetyService.removeSmeta(id);
        return "redirect:/smetyspisok";
    }

    @RequestMapping("/copysmeta/{id}")
    public String copySmeta(@PathVariable("id") int id) {
        Smety oldSmeta = this.smetyService.getSmetaById(id);
        Smety newSmeta = new Smety();
        newSmeta.setDateBegin(oldSmeta.getDateBegin());
        newSmeta.setSmetaTable(oldSmeta.getSmetaTable());
        newSmeta.setNomerSmety(oldSmeta.getNomerSmety());
        newSmeta.setNameObject(oldSmeta.getNameObject());
        newSmeta.setRekvizity(oldSmeta.getRekvizity());
        newSmeta.setNomerObject(oldSmeta.getNomerObject());
        newSmeta.setPrimechanie(oldSmeta.getPrimechanie());
        this.smetyService.addSmeta(newSmeta);
        return "redirect:/smetyspisok";
    }

    @RequestMapping("editsmeta/{id}")
    public String editSmeta(@PathVariable("id") int id, Model model) {
        model.addAttribute("smety", this.smetyService.getSmetaById(id));
        model.addAttribute("listSmety", this.smetyService.listSmety());
        model.addAttribute("smeta", new Nzt());
        model.addAttribute("listNzt", this.nztService.listNzt());
        OtherTableNzt otherTableNzt = new OtherTableNzt();
        String dop = otherTableNzt.dopProectnyeRaboty();
        model.addAttribute("dop", dop);
        Date dateBegin=this.smetyService.getSmetaById(id).getDateBegin();


        double vr = (double) otherTableNzt.getVrFullDate(dateBegin);
        model.addAttribute("vr", vr);
        return "editsmetatable";
    }

}
