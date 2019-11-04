package organizaciitelefony.calculation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class OtherTableNzt {
    public double getKoefficientTarif(double tarifnyiRazryad) {
        HashMap<Double, Double> koefTarifArray = new HashMap();
        koefTarifArray.put(9.0, 0.714);
        koefTarifArray.put(9.1, 0.72);
        koefTarifArray.put(9.2, 0.723);
        koefTarifArray.put(9.3, 0.729);
        koefTarifArray.put(9.4, 0.732);
        koefTarifArray.put(9.5, 0.738);
        koefTarifArray.put(9.6, 0.745);
        koefTarifArray.put(9.7, 0.748);
        koefTarifArray.put(9.8, 0.754);
        koefTarifArray.put(9.9, 0.757);
        koefTarifArray.put(10.0, 0.763);
        koefTarifArray.put(10.1, 0.769);
        koefTarifArray.put(10.2, 0.772);
        koefTarifArray.put(10.3, 0.778);
        koefTarifArray.put(10.4, 0.785);
        koefTarifArray.put(10.5, 0.791);
        koefTarifArray.put(10.6, 0.794);
        koefTarifArray.put(10.7, 0.8);
        koefTarifArray.put(10.8, 0.806);
        koefTarifArray.put(10.9, 0.809);
        koefTarifArray.put(11.0, 0.815);
        koefTarifArray.put(11.1, 0.822);
        koefTarifArray.put(11.2, 0.828);
        koefTarifArray.put(11.3, 0.834);
        koefTarifArray.put(11.4, 0.84);
        koefTarifArray.put(11.5, 0.846);
        koefTarifArray.put(11.6, 0.849);
        koefTarifArray.put(11.7, 0.855);
        koefTarifArray.put(11.8, 0.862);
        koefTarifArray.put(11.9, 0.868);
        koefTarifArray.put(12.0, 0.874);
        koefTarifArray.put(12.1, 0.88);
        koefTarifArray.put(12.2, 0.886);
        koefTarifArray.put(12.3, 0.892);
        koefTarifArray.put(12.4, 0.898);
        koefTarifArray.put(12.5, 0.905);
        koefTarifArray.put(12.6, 0.911);
        koefTarifArray.put(12.7, 0.917);
        koefTarifArray.put(12.8, 0.923);
        koefTarifArray.put(12.9, 0.929);
        koefTarifArray.put(13.0, 0.935);
        koefTarifArray.put(13.1, 0.942);
        koefTarifArray.put(13.2, 0.948);
        koefTarifArray.put(13.3, 0.954);
        koefTarifArray.put(13.4, 0.96);
        koefTarifArray.put(13.5, 0.969);
        koefTarifArray.put(13.6, 0.975);
        koefTarifArray.put(13.7, 0.982);
        koefTarifArray.put(13.8, 0.988);
        koefTarifArray.put(13.9, 0.994);
        koefTarifArray.put(14.0, 1.0);
        koefTarifArray.put(14.1, 1.006);
        koefTarifArray.put(14.2, 1.015);
        koefTarifArray.put(14.3, 1.022);
        koefTarifArray.put(14.4, 1.028);
        koefTarifArray.put(14.5, 1.037);
        koefTarifArray.put(14.6, 1.043);
        koefTarifArray.put(14.7, 1.049);
        koefTarifArray.put(14.8, 1.055);
        koefTarifArray.put(14.9, 1.065);
        koefTarifArray.put(15.0, 1.071);
        koefTarifArray.put(15.1, 1.077);
        koefTarifArray.put(15.2, 1.086);
        koefTarifArray.put(15.3, 1.092);
        koefTarifArray.put(15.4, 1.102);
        koefTarifArray.put(15.5, 1.108);
        koefTarifArray.put(15.6, 1.114);
        koefTarifArray.put(15.7, 1.123);
        koefTarifArray.put(15.8, 1.129);
        koefTarifArray.put(15.9, 1.138);
        koefTarifArray.put(16.0, 1.145);
        koefTarifArray.put(16.1, 1.154);
        koefTarifArray.put(16.2, 1.16);
        koefTarifArray.put(16.3, 1.169);
        koefTarifArray.put(16.4, 1.175);
        koefTarifArray.put(16.5, 1.185);
        koefTarifArray.put(16.6, 1.194);
        koefTarifArray.put(16.7, 1.2);
        koefTarifArray.put(16.8, 1.209);
        koefTarifArray.put(16.9, 1.215);
        koefTarifArray.put(17.0, 1.225);
        koefTarifArray.put(17.1, 1.234);
        koefTarifArray.put(17.2, 1.243);
        koefTarifArray.put(17.3, 1.249);
        koefTarifArray.put(17.4, 1.258);
        koefTarifArray.put(17.5, 1.268);
        koefTarifArray.put(17.6, 1.277);
        koefTarifArray.put(17.7, 1.286);
        koefTarifArray.put(17.8, 1.292);
        koefTarifArray.put(17.9, 1.302);
        koefTarifArray.put(18.0, 1.311);
        koefTarifArray.put(18.1, 1.32);
        koefTarifArray.put(18.2, 1.329);
        koefTarifArray.put(18.3, 1.338);
        koefTarifArray.put(18.4, 1.348);
        koefTarifArray.put(18.5, 1.357);
        koefTarifArray.put(18.6, 1.366);
        koefTarifArray.put(18.7, 1.375);
        koefTarifArray.put(18.8, 1.385);
        koefTarifArray.put(18.9, 1.394);
        return koefTarifArray.get(tarifnyiRazryad);
    }

    //ПРОГНОЗНЫЕ ИНДЕКСЫ ЦЕН В СТРОИТЕЛЬСТВЕ,
    //УСТАНОВЛЕННЫЕ МИНИСТЕРСТВОМ АРХИТЕКТУРЫ И СТРОИТЕЛЬСТВА
    //РЕСПУБЛИКИ БЕЛАРУСЬ
    public double prognoznyiIndexCen(double monthYear) {
        HashMap<Double, Double> prognoznyiIndexCenByMonth = new HashMap();
        prognoznyiIndexCenByMonth.put(1.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(2.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(3.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(4.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(5.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(6.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(7.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(8.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(9.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(10.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(11.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(12.2018, 1.0066);
        prognoznyiIndexCenByMonth.put(1.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(2.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(3.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(4.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(5.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(6.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(7.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(8.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(9.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(10.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(11.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(12.2019, 1.0053);
        prognoznyiIndexCenByMonth.put(1.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(2.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(3.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(4.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(5.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(6.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(7.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(8.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(9.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(10.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(11.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(12.2020, 1.0049);
        prognoznyiIndexCenByMonth.put(1.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(2.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(3.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(4.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(5.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(6.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(7.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(8.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(9.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(10.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(11.2021, 1.0047);
        prognoznyiIndexCenByMonth.put(12.2021, 1.0047);
        return prognoznyiIndexCenByMonth.get(monthYear);
    }

    public double getVr(double monthYear) {
        /* Установить для определения стоимости разработки документации проектного обеспечения строительной деятельности ресурсным методом стоимость работ (услуг), приходящуюся на 1 человеко-день работы исполнителя 14 разряда, по состоянию на 1 января 2019 г. в размере 189 руб. 71 коп.*//**//*
         */
        double stoimostRazrabotkiIspolnitelya14Razryada = 189.71;
        //получить месяц
        int mesyac = (int) monthYear;
        double result = stoimostRazrabotkiIspolnitelya14Razryada * Math.pow(prognoznyiIndexCen(monthYear), mesyac - 1);
        return result;
    }
     public double getVrFullDate(Date date){

         SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

         SimpleDateFormat dateFormat = new SimpleDateFormat("M.yyyy");
         String dateBeginStr = dateFormat.format(date);
         double dateBegin = Double.parseDouble(dateBeginStr);
         System.out.println("Дата" + dateBegin);

         NZTR nztr = new NZTR();
         OtherTableNzt otherTableNzt = new OtherTableNzt();

         double Vr = (double) Math.round(otherTableNzt.getVr(dateBegin) * 100) / 100;
         System.out.println("vr=" + Vr);

         return Vr;
     }

    public String dopProectnyeRaboty(){
        String dopCheckBob="";
        dopCheckBob="" +                       "<p><label><input type=\"checkbox\" id=\"12.41\" value=\"Разработка раздела КЖ\" />Разработка раздела КЖ;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.42\" value=\"Раздел ООС\" />Раздел ООС;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.43\" value=\"Экологический паспорт проекта\" />Экологический паспорт проекта;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.2\" value=\"Разработка раздела «Оценка воздействия на окружающую среду» (ОВОС), раздела «Охрана окружающей природной среды» (если не разрабатывается раздел ОВОС), включая экологический паспорт объекта и определение нормативов предельно допустимых выбросов\" /> 12.2 разработка раздела «Оценка воздействия на окружающую среду» (ОВОС), раздела «Охрана окружающей природной среды» (если не разрабатывается раздел ОВОС), включая экологический паспорт объекта и определение нормативов предельно допустимых выбросов;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.4\" value=\"Разработка раздела «Инженерно-технические мероприятия гражданской обороны. Мероприятия по предупреждению чрезвычайных ситуаций»\" /> 12.4 разработка раздела «Инженерно-технические мероприятия гражданской обороны. Мероприятия по предупреждению чрезвычайных ситуаций»;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.10\" value=\"Разработка проектных решений по благоустройству (включая генеральный план, организацию рельефа) и дополнительных мероприятий, связанных с рельефом площадки (озеленение территории, откосы, подпорные стенки, лестницы, канавы, лотки и т.п.)\" /> 12.10 разработка проектных решений по благоустройству (включая генеральный план, организацию рельефа) и дополнительных мероприятий, связанных с рельефом площадки (озеленение территории, откосы, подпорные стенки, лестницы, канавы, лотки и т.п.);</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.15\" value=\"Разработка дизайн-проектов, художественно-декоративных и цветовых решений, проектов подсветки зданий\" /> 12.15 разработка дизайн-проектов, художественно-декоративных и цветовых решений, проектов подсветки зданий;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.31\" value=\"Разработка систем автоматизации\" /> 12.31 разработка систем автоматизации;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.34\" value=\"Разработка систем молниезащиты\" /> 12.34 разработка систем молниезащиты;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.1\" value=\"Разработка раздела «Экономическая эффективность»\" /> 12.1 разработка раздела «Экономическая эффективность»;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.3\" value=\"Разработка разделов «Промышленная безопасность» и «Защита информации»\" /> 12.3 разработка разделов «Промышленная безопасность» и «Защита информации»;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.5\" value=\"Разработка раздела «Организация и условия труда работников», «Управление производством и предприятием»\" /> 12.5 разработка раздела «Организация и условия труда работников», «Управление производством и предприятием»;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.6\" value=\"Разработка проектных решений, связанных с подготовкой площадки строительства (снос здания, вынос инженерных сетей, выторфовка, вырубка деревьев, разборка и восстановление покрытий и т. д.)\" /> 12.6 разработка проектных решений, связанных с подготовкой площадки строительства (снос здания, вынос инженерных сетей, выторфовка, вырубка деревьев, разборка и восстановление покрытий и т. д.);</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.7\" value=\"Разработка дополнительных вариантов проекта или отдельных технологических, конструктивных, архитектурных и других решений, за исключением вариантных проработок для выбора оптимальных проектных решений\" /> 12.7 разработка дополнительных вариантов проекта или отдельных технологических, конструктивных, архитектурных и других решений, за исключением вариантных проработок для выбора оптимальных проектных решений;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.8\" value=\"Разработка проектной документации для временных зданий и сооружений для нужд строительных организаций\" /> 12.8 разработка проектной документации для временных зданий и сооружений для нужд строительных организаций;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.9\" value=\"Разработка проектной документации для объектов инженерной инфраструктуры (внутриплощадочных и внеплощадочных инженерных сетей и сооружений)\" /> 12.9 разработка проектной документации для объектов инженерной инфраструктуры (внутриплощадочных и внеплощадочных инженерных сетей и сооружений);</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.11\" value=\"Разработка проектной документации для рекультивации земель\" /> 12.11 разработка проектной документации для рекультивации земель;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.12\" value=\"Разработка проекта организации санитарно-защитной зоны (СЗЗ)\" /> 12.12 разработка проекта организации санитарно-защитной зоны (СЗЗ);</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.13\" value=\"Выполнение расчетов естественной освещенности и инсоляции жилых и общественных помещений проектируемых зданий (только для проекта застройки)\" /> 12.13 выполнение расчетов естественной освещенности и инсоляции жилых и общественных помещений проектируемых зданий (только для проекта застройки);</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.14\" value=\"Разработка схем организации движения, разработка схем переноса движения городского транспорта, устройства объездов на время строительства, элементов проектирования технических средств регулирования дорожного движения\" /> 12.14 разработка схем организации движения, разработка схем переноса движения городского транспорта, устройства объездов на время строительства, элементов проектирования технических средств регулирования дорожного движения;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.16\" value=\"Разработка решений по визуально-адресному ориентированию (информационные и видео-табло, указатели, наименование кабинетов, схемы расположения знаков пожарной безопасности и т.п.)\" /> 12.16 разработка решений по визуально-адресному ориентированию (информационные и видео-табло, указатели, наименование кабинетов, схемы расположения знаков пожарной безопасности и т.п.);</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.17\" value=\"Разработка рекламных устройств на зданиях и сооружениях\" /> 12.17 разработка рекламных устройств на зданиях и сооружениях;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.18\" value=\"Второй вариант расчетов высотных зданий, выполняемый независимой организацией, расчеты конструкций пролетами свыше 36 м\" /> 12.18 второй вариант расчетов высотных зданий, выполняемый независимой организацией, расчеты конструкций пролетами свыше 36 м;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.19\" value=\"Разработка проектных решений по специальным методам строительства\" /> 12.19 разработка проектных решений по специальным методам строительства;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.20\" value=\"Разработка мероприятий по антикоррозионной защите\" /> 12.20 разработка мероприятий по антикоррозионной защите;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.21\" value=\"Разработка проектной документации для повысительных насосных станций (пожарных, хозяйственных, технологических)\" /> 12.21 разработка проектной документации для повысительных насосных станций (пожарных, хозяйственных, технологических);</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.22\" value=\"Разделение систем по отдельным потребителям, зонирование систем отопления и водоснабжения для повышения гидравлической надежности систем здания\" /> 12.22 разделение систем по отдельным потребителям, зонирование систем отопления и водоснабжения для повышения гидравлической надежности систем здания;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.23\" value=\"Разработка проектной документации для очистных сооружений\" /> 12.23 разработка проектной документации для очистных сооружений;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.24\" value=\"Разработка проектной документации для пылеулавливающих сооружений\" /> 12.24 разработка проектной документации для пылеулавливающих сооружений;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.25\" value=\"Разработка центральных систем пылеудаления\" /> 12.25 разработка центральных систем пылеудаления;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.26\" value=\"Разработка систем дымоудаления\" /> 12.26 разработка систем дымоудаления;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.27\" value=\"Разработка систем кондиционирования и рекуперации\" /> 12.27 разработка систем кондиционирования и рекуперации;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.28\" value=\"Разработка систем заземления и уравнивания потенциалов\" /> 12.28 разработка систем заземления и уравнивания потенциалов;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.29\" value=\"Разработка автоматизированных систем управления инженерным оборудованием\" /> 12.29 разработка автоматизированных систем управления инженерным оборудованием;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.30\" value=\"Разработка систем диспетчеризации\" /> 12.30 разработка систем диспетчеризации;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.32\" value=\"Разработка систем телемеханики\" /> 12.32 разработка систем телемеханики;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.33\" value=\"Разработка локальных вычислительных систем\" /> 12.33 разработка локальных вычислительных систем;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.35\" value=\"Разработка систем безопасности\" /> 12.35 разработка систем безопасности;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.36\" value=\"Разработка систем холодоснабжения\" /> 12.36 разработка систем холодоснабжения;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.37\" value=\"Разработка проектной документации для устройств связи и сигнализации\" /> 12.37 разработка проектной документации для устройств связи и сигнализации;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.38\" value=\"Разработка проектной документации для систем видеопоказа, звукоусиления, синхронного перевода речи, судейства, специальной связи, телевидения\" /> 12.38 разработка проектной документации для систем видеопоказа, звукоусиления, синхронного перевода речи, судейства, специальной связи, телевидения;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.39\" value=\"Разработка систем пожарной и охранной сигнализации, видеонаблюдения, домофонных систем (охранно-переговорных), учрежденческих телефонных станций\" /> 12.39 разработка систем пожарной и охранной сигнализации, видеонаблюдения, домофонных систем (охранно-переговорных), учрежденческих телефонных станций;</label></p>"+
                "<p><label><input type=\"checkbox\" id=\"12.40\" value=\"Дополнительные проектные работы (услуги), перечисленные в общих положениях и разделах Сборников НЗТ, а также в указаниях и примечаниях, относящихся к таблице и(или) конкретной позиции Сборников НЗТ.\" /> 12.40 дополнительные проектные работы (услуги), перечисленные в общих положениях и разделах Сборников НЗТ, а также в указаниях и примечаниях, относящихся к таблице и(или) конкретной позиции Сборников НЗТ.</label></p>";

        return dopCheckBob;
    }

}
