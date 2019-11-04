package organizaciitelefony.russiandate;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RussianDate {
 public String russianDateFormat(Date date) {
     String[] russianMonat =
             {
                     "января",
                     "февраля",
                     "марта",
                     "апреля",
                     "мая",
                     "июня",
                     "июля",
                     "августа",
                     "сентября",
                     "октября",
                     "ноября",
                     "декабря"
             };
     Locale local = new Locale("ru","RU");
     DateFormatSymbols russSymbol = new DateFormatSymbols(local);
     russSymbol.setMonths(russianMonat);
     SimpleDateFormat sdf = new SimpleDateFormat("«d» MMMM yyyy ", russSymbol);
     return sdf.format(date);
 }

}
