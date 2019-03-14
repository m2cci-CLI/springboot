package com.training.springcore.bigcorp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@DiscriminatorValue("FIXED")
public class FixedCaptor extends Captor{
    @NotNull
    private String defaultPowerInWatt;


    @Deprecated

    public FixedCaptor() {
        super();
// used only by serializer and deserializer
    }

    public FixedCaptor(String id, String name, Site site, String defaultPowerInWatt) {
        super(id, name, site);
        this.defaultPowerInWatt = defaultPowerInWatt;
    }

    public FixedCaptor(String name, String defaultPowerInWatt) {
        super(name);
        this.defaultPowerInWatt = defaultPowerInWatt;
    }

    public FixedCaptor(String name,Site site) {
        super(name, site);
    }

    public FixedCaptor(String name, Site site, String defaultPowerInWatt) {
        super(name, site);
        this.defaultPowerInWatt = defaultPowerInWatt;
    }
}
