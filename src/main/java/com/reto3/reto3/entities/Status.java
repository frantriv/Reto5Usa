package com.reto3.reto3.entities;

import java.io.Serializable;

public class Status implements Serializable {
    public int completed;
    public int cancelled;

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    public int getCompleted() {
        return completed;
    }

    public int getCancelled() {
        return cancelled;
    }
}
