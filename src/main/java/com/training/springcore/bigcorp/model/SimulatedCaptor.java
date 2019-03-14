package com.training.springcore.bigcorp.model;
import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;


@Entity
@DiscriminatorValue("SIMULATED")
public class SimulatedCaptor extends Captor{
    @NotNull
    private String minPowerInWatt;
    @NotNull
    private String maxPowerInWatt;

    @Deprecated
    public SimulatedCaptor() {
        super();
// used only by serializer and deserializer
    }



    public SimulatedCaptor(String id, String name, Site site, String minPowerInWatt, String maxPowerInWatt) {
        super(id, name, site);
        this.minPowerInWatt = minPowerInWatt;
        this.maxPowerInWatt = maxPowerInWatt;
    }

    public SimulatedCaptor(String name, String minPowerInWatt, String maxPowerInWatt) {
        super(name);
        this.minPowerInWatt = minPowerInWatt;
        this.maxPowerInWatt = maxPowerInWatt;
    }

    public SimulatedCaptor(Site site, String minPowerInWatt, String maxPowerInWatt) {
        super(site);
        this.minPowerInWatt = minPowerInWatt;
        this.maxPowerInWatt = maxPowerInWatt;
    }

    public SimulatedCaptor(String name, Site site, String minPowerInWatt, String maxPowerInWatt) {
        super(name, site);
        this.minPowerInWatt = minPowerInWatt;
        this.maxPowerInWatt = maxPowerInWatt;
    }
}
