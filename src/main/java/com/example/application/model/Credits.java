package com.example.application.model;

import javax.persistence.*;

@Entity
@Table(name="credits")
public class Credits {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long idDocument;
    private Long idCustomers;
    private Long idWorkers;
    private String state;

    public Credits(Long idDocument, Long idCustomers, String state, Long idWorker) {
        this.idDocument = idDocument;
        this.idCustomers = idCustomers;
        this.state = state;
        this.idWorkers = idWorker;
    }

    public Credits() {
    }

    public Long getIdWorkers() {
        return idWorkers;
    }

    public void setIdWorkers(Long idWorkers) {
        this.idWorkers = idWorkers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Long idDocument) {
        this.idDocument = idDocument;
    }

    public Long getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(Long idCustomers) {
        this.idCustomers = idCustomers;
    }

}
