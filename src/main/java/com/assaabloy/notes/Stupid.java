package com.assaabloy.notes;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Stupid  {

    private String stupid;

    public Stupid() {
        // needed..for Jackson
    }

    public Stupid(String stupid) {
        this.stupid = stupid;
    }

    @JsonProperty
    public String getStupid() {
        return stupid;
    }
}
