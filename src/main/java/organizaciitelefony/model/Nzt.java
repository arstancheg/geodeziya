package organizaciitelefony.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import organizaciitelefony.model.NZTNorm;

@Entity
@Table(name = "NZT")
public class Nzt {
    @Id
    @Column(name = "id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NZT_name")
    private String nztName;
    @Column(name = "NZT_number")
    private String nztNumber;
    @Column(name = "NZT_full")
    private int nztFull;

    @OneToMany(mappedBy = "nzt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NZTNorm> norms = new ArrayList<NZTNorm>();

    public String getNztNumber() {
        return nztNumber;
    }

    public void setNztNumber(String nztNumber) {
        this.nztNumber = nztNumber;
    }

    public int getNztFull() {
        return nztFull;
    }

    public void setNztFull(int nztFull) {
        this.nztFull = nztFull;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNztName() {
        return nztName;
    }

    public void setNztName(String nztName) {
        this.nztName = nztName;
    }

    public List<NZTNorm> getNorms() {
        return norms;
    }

    public void setNorms(List<NZTNorm> norms) {
        this.norms = norms;
    }

/*    @Override
    public String toString() {
        return "Nzt{" +
                "id=" + id +
                ", nztName='" + nztName + '\'' +
                ", nztNumber='" + nztNumber + '\'' +
                ", nztFull=" + nztFull +
                ", norms=" + norms +
                '}';
    }*/
}


