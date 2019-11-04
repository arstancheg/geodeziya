package organizaciitelefony.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Proxy(lazy = false)
@Table(name = "ish_dannye")
public class Geodeziya {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fio")
    private String fio;
    @Column(name = "passport_seriya")
    private String passportSeriya;
    @Column(name = "passport_nomer")
    private int passportNomer;
    @Column(name = "kem_vydan")
    private String kemVydan;
    @Column(name = "kogda_vydan")
    private Date kogdaVydan;
    @Column(name = "nasel_punkt")
    private String naselPunkt;

    @Column(name = "ulica")
    private String ulica;

    @Column(name = "dom")
    private String dom;

    @Column(name = "korpus")
    private String korpus;

    @Column(name = "kvartira")
    private String kvartira;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "object")
    private String nameObject;

    @Column(name = "nomer_dogovara")
    private String nomerDogovara;

    @Column(name = "data_dogovara")
    private Date dataDogovara;

    @Column(name = "srok")
    private int srok;

    @Column(name = "polevoi_tarif")
    private double polevoiTarif;

    @Column(name = "kamer_tarif")
    private double kamerTarif;

    @Column(name = "obem")
    private double obem;

    @Column(name = "transportnye")
    private double transportnye;

    @Column(name = "zimn_udorozhanie")
    private double zimnUdorozhanie;


    @Column(name = "koef_perescheta")
    private double koefPerescheta;

    @Column(name = "data_act", columnDefinition = "Date default 01-01-2019")
    private Date dataAct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPassportSeriya() {
        return passportSeriya;
    }

    public void setPassportSeriya(String passportSeriya) {
        this.passportSeriya = passportSeriya;
    }

    public int getPassportNomer() {
        return passportNomer;
    }

    public void setPassportNomer(int passportNomer) {
        this.passportNomer = passportNomer;
    }

    public String getKemVydan() {
        return kemVydan;
    }

    public void setKemVydan(String kemVydan) {
        this.kemVydan = kemVydan;
    }

    public Date getKogdaVydan() {
        return kogdaVydan;
    }

    public void setKogdaVydan(Date kogdaVydan) {
        this.kogdaVydan = kogdaVydan;
    }

    public String getNaselPunkt() {
        return naselPunkt;
    }

    public void setNaselPunkt(String naselPunkt) {
        this.naselPunkt = naselPunkt;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getKorpus() {
        return korpus;
    }

    public void setKorpus(String korpus) {
        this.korpus = korpus;
    }

    public String getKvartira() {
        return kvartira;
    }

    public void setKvartira(String kvartira) {
        this.kvartira = kvartira;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }

    public String getNomerDogovara() {
        return nomerDogovara;
    }

    public void setNomerDogovara(String nomerDogovara) {
        this.nomerDogovara = nomerDogovara;
    }

    public Date getDataDogovara() {
        return dataDogovara;
    }

    public void setDataDogovara(Date dataDogovara) {
        this.dataDogovara = dataDogovara;
    }

    public int getSrok() {
        return srok;
    }

    public void setSrok(int srok) {
        this.srok = srok;
    }

    public double getPolevoiTarif() {
        return polevoiTarif;
    }

    public void setPolevoiTarif(double polevoiTarif) {
        this.polevoiTarif = polevoiTarif;
    }

    public double getKamerTarif() {
        return kamerTarif;
    }

    public void setKamerTarif(double kamerTarif) {
        this.kamerTarif = kamerTarif;
    }

    public double getObem() {
        return obem;
    }

    public void setObem(double obem) {
        this.obem = obem;
    }

    public double getTransportnye() {
        return transportnye;
    }

    public void setTransportnye(double transportnye) {
        this.transportnye = transportnye;
    }

    public double getZimnUdorozhanie() {
        return zimnUdorozhanie;
    }

    public void setZimnUdorozhanie(double zimnUdorozhanie) {
        this.zimnUdorozhanie = zimnUdorozhanie;
    }

    public double getKoefPerescheta() {
        return koefPerescheta;
    }

    public void setKoefPerescheta(double koefPerescheta) {
        this.koefPerescheta = koefPerescheta;
    }

    public Date getDataAct() {
        return dataAct;
    }

    public void setDataAct(Date dataAct) {
        this.dataAct = dataAct;
    }

    @Override
    public String toString() {
        return "Geodeziya{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", passportSeriya='" + passportSeriya + '\'' +
                ", passportNomer=" + passportNomer +
                ", kemVydan='" + kemVydan + '\'' +
                ", kogdaVydan=" + kogdaVydan +
                ", naselPunkt='" + naselPunkt + '\'' +
                ", ulica='" + ulica + '\'' +
                ", dom='" + dom + '\'' +
                ", korpus='" + korpus + '\'' +
                ", kvartira='" + kvartira + '\'' +
                ", telephone='" + telephone + '\'' +
                ", nameObject='" + nameObject + '\'' +
                ", nomerDogovara='" + nomerDogovara + '\'' +
                ", dataDogovara=" + dataDogovara +
                ", srok=" + srok +
                ", polevoiTarif=" + polevoiTarif +
                ", kamerTarif=" + kamerTarif +
                ", obem=" + obem +
                ", transportnye=" + transportnye +
                ", zimnUdorozhanie=" + zimnUdorozhanie +
                ", koefPerescheta=" + koefPerescheta +
                ", dataAct=" + dataAct +
                '}';
    }
}
