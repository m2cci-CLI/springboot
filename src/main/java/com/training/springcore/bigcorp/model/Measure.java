package com.training.springcore.bigcorp.model;

import java.time.Instant;
import java.util.Objects;

public class Measure {

    private Instant instant; //instant au format UTC  où la date a été lue
    private Integer valueInWatt; //value en watt
    private Captor captor;
    private long id ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Measure(Instant instant, Integer valueInWatt, Captor captor) {
        this.instant = instant;
        this.valueInWatt = valueInWatt;
        this.captor = captor;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Integer getValueInWatt() {
        return valueInWatt;
    }

    public void setValueInWatt(Integer valueInWatt) {
        this.valueInWatt = valueInWatt;
    }

    public Captor getCaptor() {
        return captor;
    }

    public void setCaptor(Captor captor) {
        this.captor = captor;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measure measure = (Measure) o;
        return Objects.equals(instant, measure.instant) && Objects.equals(valueInWatt, measure.valueInWatt) && Objects.equals(captor, measure.captor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instant, valueInWatt, captor);
    }
}