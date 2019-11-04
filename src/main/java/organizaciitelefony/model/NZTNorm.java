package organizaciitelefony.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NZT_norm")
public class NZTNorm {
    @Id
    @Column(name = "id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Nzt.class)
    @JoinColumn(name = "NZT_id")
    private Nzt nzt;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = NztTable.class)
    @JoinColumn(name = "NZT_table_id")
    private NztTable nztTable;
    @Column(name = "id_norm")
    private String idNorm;
    @Column(name = "name_object")
    private String nameObject;
    @Column(name = "value_natural_object")
    private double valueNaturalObject;
    @Column(name = "razryad_slozhnosti")
    private double razryadSlozhnosti;
    @Column(name = "norma_zatrat")
    private double normaZatrat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nzt getNzt() {
        return nzt;
    }

    public void setNzt(Nzt nzt) {
        this.nzt = nzt;
    }

    public NztTable getNztTable() {
        return nztTable;
    }

    public void setNztTable(NztTable nztTable) {
        this.nztTable = nztTable;
    }

    public String getIdNorm() {
        return idNorm;
    }

    public void setIdNorm(String idNorm) {
        this.idNorm = idNorm;
    }

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }

    public double getValueNaturalObject() {
        return valueNaturalObject;
    }

    public void setValueNaturalObject(double valueNaturalObject) {
        this.valueNaturalObject = valueNaturalObject;
    }

    public double getRazryadSlozhnosti() {
        return razryadSlozhnosti;
    }

    public void setRazryadSlozhnosti(double razryadSlozhnosti) {
        this.razryadSlozhnosti = razryadSlozhnosti;
    }

    public double getNormaZatrat() {
        return normaZatrat;
    }

    public void setNormaZatrat(double normaZatrat) {
        this.normaZatrat = normaZatrat;
    }

    @Override
    public String toString() {
        return "NZTNorm{" +
                "id=" + id +
                ", nzt=" + nzt +
                ", nztTable=" + nztTable +
                ", idNorm='" + idNorm + '\'' +
                ", nameObject='" + nameObject + '\'' +
                ", valueNaturalObject=" + valueNaturalObject +
                ", razryadSlozhnosti=" + razryadSlozhnosti +
                ", normaZatrat=" + normaZatrat +
                '}';
    }
}
