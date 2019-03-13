package com.training.springcore.bigcorp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;
@Entity
public class Captor {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Site site ;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PowerSource powerSource;
    @Column
    private Integer defaultPowerInWatt;



    public Site getSite() {
        return site;
    }

    public Captor(String name , Site site) {
        this.name = name;
        this.site = site;
    }

    public Captor(String id, String name, PowerSource powerSource, Site site) {
        this.id = id;
        this.name = name;
        this.powerSource = powerSource;
        this.site = site;
    }

    public Captor(String id, String name, PowerSource powerSource, Integer defaultPowerInWatt, Site site) {
        this.id = id;
        this.name = name;
        this.powerSource = powerSource;
        this.defaultPowerInWatt = defaultPowerInWatt;
        this.site = site;
    }

    @Deprecated
    public Captor() {
        // Use for serializer or deserializer
    }

    /**
     * Constructor to use with required property
     * @param name
     */
    public Captor(String name) {
        this.name = name;

    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    public Integer getDefaultPowerInWatt() {
        return defaultPowerInWatt;
    }

    public void setDefaultPowerInWatt(Integer defaultPowerInWatt) {
        this.defaultPowerInWatt = defaultPowerInWatt;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Captor site = (Captor) o;
        return Objects.equals(name, site.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Captor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
