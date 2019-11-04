package organizaciitelefony.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Proxy(lazy = false)
@Table(name = "ish_dannye_dlya_yur")
public class GeodeziyaYur {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

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
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Rekvizity.class)
    @JoinColumn(name = "zakazchik")
    private Rekvizity rekvizity;

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

    public Rekvizity getRekvizity() {
        return rekvizity;
    }

    public void setRekvizity(Rekvizity rekvizity) {
        this.rekvizity = rekvizity;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
