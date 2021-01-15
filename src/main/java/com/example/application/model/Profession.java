package com.example.application.model;

import javax.persistence.*;

@Entity
@Table(name="profession")
public class Profession {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
   private Long idCustomer;
   private String nameProfession;
   private String professionDistrict;
   private String professionRisk;
   private int experience;

    public Profession() {
    }

    public Profession(Long idCustomer, String nameProfession, String professionDistrict, String professionRisk, int experience) {
        this.idCustomer = idCustomer;
        this.nameProfession = nameProfession;
        this.professionDistrict = professionDistrict;
        this.professionRisk = professionRisk;
        this.experience = experience;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameProfession() {
        return nameProfession;
    }

    public void setNameProfession(String nameProfession) {
        this.nameProfession = nameProfession;
    }

    public String getProfessionDistrict() {
        return professionDistrict;
    }

    public void setProfessionDistrict(String professionDistrict) {
        this.professionDistrict = professionDistrict;
    }

    public String getProfessionRisk() {
        return professionRisk;
    }

    public void setProfessionRisk(String professionRisk) {
        this.professionRisk = professionRisk;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int expirience) {
        this.experience = expirience;
    }
}
