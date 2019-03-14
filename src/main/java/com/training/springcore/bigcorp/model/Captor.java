package com.training.springcore.bigcorp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class  Captor {

    @Id
    private String id = UUID.randomUUID().toString();
    @Size(min = 3, max = 100)
    @NotNull
    private String name;
    @ManyToOne
    private Site site ;

    @Version
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Site getSite() {
        return site;
    }

    public Captor(Site site) {
        this.site = site;
    }



    public Captor(String name, Site site) {

      this.name = name;
        this.site = site;

    }

    public Captor(String id, String name, Site site) {
        this.id = id;
        this.name = name;

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
