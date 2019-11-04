package organizaciitelefony.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
@Table(name = "smety")

public class Smety {
    @Id

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Rekvizity.class)
    @JoinColumn(name = "id_rekvizit_phone")
    private Rekvizity rekvizity;

    @Column(name = "nomer_smety")
    private String nomerSmety;

    @Column(name = "name_object")
    private String nameObject;

    @Column(name = "smeta_table")
    private String smetaTable;

    @Column(name = "date_begin")

    private Date dateBegin;

    @Column(name = "nomer_object")
    private String nomerObject;

    @Column(name = "primechanie")
    private String primechanie;

    public String getNomerObject() {
        return nomerObject;
    }

    public void setNomerObject(String nomerObject) {
        this.nomerObject = nomerObject;
    }

    public String getPrimechanie() {
        return primechanie;
    }

    public void setPrimechanie(String primechanie) {
        this.primechanie = primechanie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rekvizity getRekvizity() {
        return rekvizity;
    }

    public void setRekvizity(Rekvizity rekvizity) {
        this.rekvizity = rekvizity;
    }

    public String getNomerSmety() {
        return nomerSmety;
    }

    public void setNomerSmety(String nomerSmety) {
        this.nomerSmety = nomerSmety;
    }

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }

    public String getSmetaTable() {
        return smetaTable;
    }

    public void setSmetaTable(String smetaTable) {
        this.smetaTable = smetaTable;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Override
    public String toString() {
        return "Smety{" +
                "id=" + id +
                ", rekvizity=" + rekvizity +
                ", nomerSmety='" + nomerSmety + '\'' +
                ", nameObject='" + nameObject + '\'' +
                ", smetaTable='" + smetaTable + '\'' +
                ", dateBegin=" + dateBegin +
                ", nomerObject='" + nomerObject + '\'' +
                ", primechanie='" + primechanie + '\'' +
                '}';
    }
}
