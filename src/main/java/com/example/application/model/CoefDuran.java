package com.example.application.model;

import javax.persistence.*;

@Entity
@Table(name="coef_duran")
public class CoefDuran {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long idCustomer;
    private int age;
    private String sex;
    private boolean bankAccount;
    private boolean property;

    public CoefDuran() {
    }

    public CoefDuran(Long idCustomer, int age, String sex, boolean bankAccount, boolean property) {
        this.idCustomer = idCustomer;
        this.age = age;
        this.sex = sex;
        this.bankAccount = bankAccount;
        this.property = property;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(boolean bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isProperty() {
        return property;
    }

    public void setProperty(boolean property) {
        this.property = property;
    }
}
