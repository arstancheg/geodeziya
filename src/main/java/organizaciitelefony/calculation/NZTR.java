package organizaciitelefony.calculation;

public class NZTR {
    public double nztLessMinimum(double nztMin, double nztMinNext, double valueObject, double valueNaturalObjectMin, double valueNaturalObjectMinNext) {
        double result = nztMin - (nztMinNext - nztMin) * (valueNaturalObjectMin - valueObject) * 0.8 / (valueNaturalObjectMinNext - valueNaturalObjectMin);
        result=(double) Math.round(result*100)/100;
                return result;
    }
    public String nztLessMinimumFormula(double nztMin, double nztMinNext, double valueObject, double valueNaturalObjectMin, double valueNaturalObjectMinNext) {
        String result = nztMin+"-("+ nztMinNext+" - "+ nztMin+") / ("+valueNaturalObjectMinNext+" - "+valueNaturalObjectMin+") * ("+valueNaturalObjectMin+" - "+valueObject+") * 0.8 ";
        return result;
    }

    public double nztMoreMax(double nztMax, double nztMaxPrev, double valueObject, double valueNaturalObjectMax, double valueNaturalObjectMaxPrev) {
        double result = nztMax - (nztMax - nztMaxPrev) * (valueObject - valueNaturalObjectMax) * 0.8 / (valueNaturalObjectMax - valueNaturalObjectMaxPrev);
        result=(double) Math.round(result*100)/100;
        return result;
    }
    public String nztMoreMaxFormula(double nztMax, double nztMaxPrev, double valueObject, double valueNaturalObjectMax, double valueNaturalObjectMaxPrev) {
        String result = nztMax+" - ("+nztMax+" - "+nztMaxPrev+") * ("+valueObject+" - "+valueNaturalObjectMax+") * 0.8 / ("+valueNaturalObjectMax+" - "+valueNaturalObjectMaxPrev+")";
        return result;
    }


    public double nztInInterval(double nztMin, double nztMax, double valueObject, double valueNaturalObjectMin, double valueNaturalObjectMax) {
        double result = nztMin + (nztMax - nztMin) * (valueObject - valueNaturalObjectMin) / (valueNaturalObjectMax - valueNaturalObjectMin);
        result=(double) Math.round(result*100)/100;
        return result;
    }
    public String nztInIntervalFormula(double nztMin, double nztMax, double valueObject, double valueNaturalObjectMin, double valueNaturalObjectMax) {
        String result = nztMin+" + ("+nztMax+" - "+nztMin+")  / ("+valueNaturalObjectMax+" - "+valueNaturalObjectMin+")* ("+valueObject+" - "+valueNaturalObjectMin+")";
        return result;
    }

}
