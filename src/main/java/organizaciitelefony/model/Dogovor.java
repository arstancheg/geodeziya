package organizaciitelefony.model;


import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.sql.Date;

@Entity
@Table(name = "dogovor")
public class Dogovor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Номер договора должен быть задан")
    @Column(name = "number_contract")
    private String numberContract;
    @NotNull(message = "Название договора должно быть указано")
    @Column(name = "name_contact")
    private String nameContact;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Rekvizity.class)
    @JoinColumn(name = "customer_id")
    private Rekvizity rekvizity;
    @Column(name = "expertise")
    private String expertise;
    @NotNull(message = "Дата должна быть указана")
    @Column(name = "date_begin")

    private Date dateBegin;
    @Column(name = "date_term")
    private byte dateTerm;
    @Column(name = "term_end")

    private Integer termEnd;
    @Column(name = "kind_days")
    private String kindDays;

    @Column(name = "date_end")
    private Date dateEnd;
    @Column(name = "prepayment")
    private byte prepayment;
    @Column(name = "start_condition")
    private String startCondition;

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

    public String getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(String numberContract) {
        this.numberContract = numberContract;
    }

    public String getNameContact() {
        return nameContact;
    }

    public void setNameContact(String nameContact) {
        this.nameContact = nameContact;
    }


    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public byte getDateTerm() {
        return dateTerm;
    }

    public void setDateTerm(byte dateTerm) {
        this.dateTerm = dateTerm;
    }

    public Integer getTermEnd() {
        return termEnd;
    }

    public void setTermEnd(Integer termEnd) {
        this.termEnd = termEnd;
    }

    public String getKindDays() {
        return kindDays;
    }

    public void setKindDays(String kindDays) {
        this.kindDays = kindDays;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public byte getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(byte prepayment) {
        this.prepayment = prepayment;
    }

    public String getStartCondition() {
        return startCondition;
    }

    public void setStartCondition(String startCondition) {
        this.startCondition = startCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dogovor dogovor = (Dogovor) o;

        if (id != dogovor.id) return false;
        if (dateTerm != dogovor.dateTerm) return false;
        if (prepayment != dogovor.prepayment) return false;
        if (numberContract != null ? !numberContract.equals(dogovor.numberContract) : dogovor.numberContract != null)
            return false;
        if (nameContact != null ? !nameContact.equals(dogovor.nameContact) : dogovor.nameContact != null) return false;
        if (expertise != null ? !expertise.equals(dogovor.expertise) : dogovor.expertise != null) return false;
        if (dateBegin != null ? !dateBegin.equals(dogovor.dateBegin) : dogovor.dateBegin != null) return false;
        if (termEnd != null ? !termEnd.equals(dogovor.termEnd) : dogovor.termEnd != null) return false;
        if (kindDays != null ? !kindDays.equals(dogovor.kindDays) : dogovor.kindDays != null) return false;
        if (dateEnd != null ? !dateEnd.equals(dogovor.dateEnd) : dogovor.dateEnd != null) return false;
        if (startCondition != null ? !startCondition.equals(dogovor.startCondition) : dogovor.startCondition != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (numberContract != null ? numberContract.hashCode() : 0);
        result = 31 * result + (nameContact != null ? nameContact.hashCode() : 0);
        result = 31 * result + (expertise != null ? expertise.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (int) dateTerm;

        result = 31 * result + (termEnd != null ? termEnd.hashCode() : 0);
        result = 31 * result + (kindDays != null ? kindDays.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (int) prepayment;
        result = 31 * result + (startCondition != null ? startCondition.hashCode() : 0);
        return result;
    }
}
