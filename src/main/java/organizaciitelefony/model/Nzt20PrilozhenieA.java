package organizaciitelefony.model;

import javax.persistence.*;


@Entity
@Table(name = "nzt20_prilozhenie_a")
public class Nzt20PrilozhenieA {
    @Id
    @Column(name = "id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "razdel_dokumentacii")
    private String razdelDokumentacii;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = VidZdaniya.class)
    @JoinColumn(name = "vid_zdaniya")
    private VidZdaniya vidZdaniya;
    @Column(name = "procent")
    private double procent;
    @Column(name = "stadii_proektirovaniya")
    private int stadiiProektirovaniya;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazdelDokumentacii() {
        return razdelDokumentacii;
    }

    public void setRazdelDokumentacii(String razdelDokumentacii) {
        this.razdelDokumentacii = razdelDokumentacii;
    }

    public VidZdaniya getVidZdaniya() {
        return vidZdaniya;
    }

    public void setVidZdaniya(VidZdaniya vidZdaniya) {
        this.vidZdaniya = vidZdaniya;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcent(double procent) {
        this.procent = procent;
    }

    public int getStadiiProektirovaniya() {
        return stadiiProektirovaniya;
    }

    public void setStadiiProektirovaniya(int stadiiProektirovaniya) {
        this.stadiiProektirovaniya = stadiiProektirovaniya;
    }
}
