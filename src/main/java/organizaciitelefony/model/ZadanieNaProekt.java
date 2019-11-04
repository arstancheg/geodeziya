package organizaciitelefony.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
@Table(name = "zadaniya_na_proekt")
public class ZadanieNaProekt {
    @Id

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "table_zadanie")
    private String tableZadanie;

    @Column(name = "name_object")
    private String nameObject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableZadanie() {
        return tableZadanie;
    }

    public void setTableZadanie(String tableZadanie) {
        this.tableZadanie = tableZadanie;
    }

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }

    @Override
    public String toString() {
        return "ZadanieNaProekt{" +
                "id=" + id +
                ", tableZadanie='" + tableZadanie + '\'' +
                ", nameObject='" + nameObject + '\'' +
                '}';
    }
}
