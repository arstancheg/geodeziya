package organizaciitelefony.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="vid_zdaniya")
public class VidZdaniya {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nameVidZdaniya")
    private String nameVidZdaniya;

    @OneToMany( mappedBy = "vidZdaniya", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nzt20PrilozhenieA> nzt20PrilozhenieA = new ArrayList<Nzt20PrilozhenieA>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameVidZdaniya() {
        return nameVidZdaniya;
    }

    public void setNameVidZdaniya(String nameVidZdaniya) {
        this.nameVidZdaniya = nameVidZdaniya;
    }

    public List<Nzt20PrilozhenieA> getNzt20PrilozhenieA() {
        return nzt20PrilozhenieA;
    }

    public void setNzt20PrilozhenieA(List<Nzt20PrilozhenieA> nzt20PrilozhenieA) {
        this.nzt20PrilozhenieA = nzt20PrilozhenieA;
    }
}
