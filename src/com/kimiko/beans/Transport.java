package com.kimiko.beans;


import javax.persistence.*;

@Entity
@Table(name = "Transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "transport")
    private String transport;

    public Transport() {
    }

    public Transport(String transport) {
        this.transport = transport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "Transport [id=" + id + ", transport=" + transport + "]";
    }
}

