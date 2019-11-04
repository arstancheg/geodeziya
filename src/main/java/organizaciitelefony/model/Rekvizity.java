package organizaciitelefony.model;

import javax.persistence.*;
import java.util.*;

import organizaciitelefony.model.Dogovor;


@Entity
@Table(name = "rekvizit_phone")

public class Rekvizity {

    @Id

    @Column(name = "ID")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME_ORGANIZATION")
    private String nameOrganization;

    @Column(name = "REKVIZIT_ORGANIZATION")
    private String rekvizitOrganization;

    @Column(name = "PHONE_ORGANIZATION")
    private String phoneOrganization;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "POSITION_ROD_PADEZH")
    private String positionRodPadezh;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "FULL_NAME_ROD_PADEZH")
    private String fullNameRodPadezh;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionRodPadezh() {
        return positionRodPadezh;
    }

    public void setPositionRodPadezh(String positionRodPadezh) {
        this.positionRodPadezh = positionRodPadezh;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullNameRodPadezh() {
        return fullNameRodPadezh;
    }

    public void setFullNameRodPadezh(String fullNameRodPadezh) {
        this.fullNameRodPadezh = fullNameRodPadezh;
    }


   /* @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private Set<Dogovor> DogovorList;*/


    @OneToMany(mappedBy = "rekvizity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dogovor> dogovors = new ArrayList<Dogovor>();

    @OneToMany(mappedBy = "rekvizity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Smety> smeties = new ArrayList<Smety>();

    public List<Dogovor> getDogovors() {
        return dogovors;
    }

    public void setDogovors(List<Dogovor> dogovors) {
        this.dogovors = dogovors;
    }

    public List<Smety> getSmeties() {
        return smeties;
    }

    public void setSmeties(List<Smety> smeties) {
        this.smeties = smeties;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public String getRekvizitOrganization() {
        return rekvizitOrganization;
    }

    public void setRekvizitOrganization(String rekvizitOrganization) {
        this.rekvizitOrganization = rekvizitOrganization;
    }

    public String getPhoneOrganization() {
        return phoneOrganization;
    }

    public void setPhoneOrganization(String phoneOrganization) {
        this.phoneOrganization = phoneOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rekvizity)) return false;
        Rekvizity rekvizity = (Rekvizity) o;
        return id == rekvizity.id &&
                nameOrganization.equals(rekvizity.nameOrganization) &&
                rekvizitOrganization.equals(rekvizity.rekvizitOrganization) &&
                phoneOrganization.equals(rekvizity.phoneOrganization) &&
                position.equals(rekvizity.position) &&
                positionRodPadezh.equals(rekvizity.positionRodPadezh) &&
                fullName.equals(rekvizity.fullName) &&
                fullNameRodPadezh.equals(rekvizity.fullNameRodPadezh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOrganization, rekvizitOrganization, phoneOrganization, position, positionRodPadezh, fullName, fullNameRodPadezh);
    }

/*    @Override
    public String toString() {
        return "Rekvizity{" +
                "id=" + id +
             *//*   ", nameOrganization='" + nameOrganization + '\'' +
                ", rekvizitOrganization='" + rekvizitOrganization + '\'' +
                ", phoneOrganization='" + phoneOrganization + '\'' +
                ", position='" + position + '\'' +
                ", positionRodPadezh='" + positionRodPadezh + '\'' +
                ", fullName='" + fullName + '\'' +
                ", fullNameRodPadezh='" + fullNameRodPadezh + '\'' +*//*
                '}';
    }*/
}
