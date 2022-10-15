package com.fredypuentes.Ciclo3G11.model.reports;

import com.fredypuentes.Ciclo3G11.model.Client;

public class CountStatus {
    private int completed;
    private int cancelled;

    public CountStatus(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
}
