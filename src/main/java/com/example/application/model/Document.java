package com.example.application.model;

import javax.persistence.*;

@Entity
@Table(name="document")
public class Document {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long idCustomer;
    private Long idWorker;
    private String status;
    private int sum;
    private int percent;
    private int duration;
    private float coef;
    private String checked;

    public Document() {
    }

    public Document(int sum, int percent, int duration, String checked) {
        this.sum = sum;
        this.percent = percent;
        this.duration = duration;
        this.checked = checked;
    }


    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public boolean isAccepted(){

        if (this.getStatus().equals("ACCEPTED")){
            return true;
        }
        else return false;
    }

    public boolean isChecked() {

        if (this.getChecked().equals("APPROVED")||this.getChecked().equals("DECLINED"))
        {return true;}
        else return false;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }



    public boolean isWaited(){
        if (this.getStatus().equals("WAITED")){
            return true;
        }
        else return false;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(Long idWorker) {
        this.idWorker = idWorker;
    }

    public int getSum() {
        return sum;
    }

    public int getPercent() {
        return percent;
    }

    public int getDuration() {
        return duration;
    }
}
