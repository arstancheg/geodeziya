package organizaciitelefony.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "NZT_table")
public class NztTable {
    @Id
    @Column(name = "id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Nzt.class)
    @JoinColumn(name = "NZT_id")
    private Nzt nzt;
    @Column(name = "NZT_table_name")
    private String nztTableName;
    @Column(name = "NZT_table_number")
    private String nztTableNumber;

    @OneToMany( mappedBy = "nztTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NZTNorm> norms = new ArrayList<NZTNorm>();

    public String getNztTableNumber() {
        return nztTableNumber;
    }

    public List<NZTNorm> getNorms() {
        return norms;
    }

    public void setNorms(List<NZTNorm> norms) {
        this.norms = norms;
    }

    public void setNztTableNumber(String nztTableNumber) {
        this.nztTableNumber = nztTableNumber;
    }

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

    public String getNztTableName() {
        return nztTableName;
    }

    public void setNztTableName(String nztTableName) {
        this.nztTableName = nztTableName;
    }

    @Override
    public String toString() {
        return "NztTable{" +
                "id=" + id +
                ", nzt=" + nzt +
                ", nztTableName='" + nztTableName + '\'' +
                ", nztTableNumber='" + nztTableNumber + '\'' +
                '}';
    }
}
