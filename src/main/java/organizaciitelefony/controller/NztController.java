package organizaciitelefony.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import organizaciitelefony.excel.ReadXlsx;
import organizaciitelefony.model.NZTNorm;
import organizaciitelefony.model.NztTable;
import organizaciitelefony.service.NztNormService;
import organizaciitelefony.service.NztService;
import organizaciitelefony.service.NztTableService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Controller
public class NztController {
    @Autowired
    private NztNormService nztNormService;
    @Autowired
    private NztTableService nztTableService;
    @Autowired
    private NztService nztService;
    @RequestMapping(value = "addnzt", method = RequestMethod.GET)
    public String addNzt() {
        String put = "D:\\projectjava\\nzt26.xlsx";
        // System.out.println(ReadXlsx.parse(put));
        NZTNorm nztNorm = new NZTNorm();

     /*   nztNorm.setNztId(20);
        nztNorm.setNztTableId(19);
        nztNorm.setIdNorm("7868f");
        nztNorm.setNameObject("какой-то объект");
        nztNorm.setValueNaturalObject(11);
        nztNorm.setRazryadSlozhnosti(14.5);
        nztNorm.setNormaZatrat(333.5);*/


        String result = "";
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(put);
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();

            int i = 0;
            while (cells.hasNext()) {
                i++;
                System.out.println(i);
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                //перебираем возможные типы ячеек
                switch (i) {
                    case 1:
                        int a = (int) cell.getNumericCellValue();
                        System.out.println("nzt_id="+a);
                        nztNorm.setNzt(nztService.getNztById(a));

                        break;
                    case 2:
                        int b = (int) cell.getNumericCellValue();
                        //System.out.println(b);
                       // nztNorm.setNztTableId(b);
                        nztNorm.setNztTable(this.nztTableService.getNztTableById(b));

                        break;
                    case 3:
                       // System.out.println(cell.getStringCellValue());
                        nztNorm.setIdNorm(cell.getStringCellValue());

                        break;
                    case 4:
                       // System.out.println(cell.getStringCellValue());
                        nztNorm.setNameObject(cell.getStringCellValue());
                        break;

                    case 5:
                       // System.out.println(cell.getNumericCellValue());
                        nztNorm.setValueNaturalObject(cell.getNumericCellValue());
                        break;
                    case 6:
                       // System.out.println(cell.getNumericCellValue());
                        nztNorm.setRazryadSlozhnosti(cell.getNumericCellValue());
                        break;
                    case 7:
                       // System.out.println(cell.getNumericCellValue());
                        nztNorm.setNormaZatrat(cell.getNumericCellValue());
                        break;

                }
            }
            this.nztNormService.addNztNorm(nztNorm);
        }

        return "addnzt";
    }

}
