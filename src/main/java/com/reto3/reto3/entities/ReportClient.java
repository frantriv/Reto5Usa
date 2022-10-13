package com.reto3.reto3.entities;

import java.io.Serializable;

public class ReportClient implements Serializable {
    public int total;
    public Client client;

    public int getTotal() {
        return total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}