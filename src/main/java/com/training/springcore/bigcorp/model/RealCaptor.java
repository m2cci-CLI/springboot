package com.training.springcore.bigcorp.model;
import javax.persistence.*;


@Entity
@DiscriminatorValue("REALCAPTOR")
public class RealCaptor extends  Captor{


    @Deprecated
    public RealCaptor() {
        super();
// used only by serializer and deserializer
    }
    public RealCaptor(String name, Site site) {
        super(name, site);
    }

    public RealCaptor(String id, String name, Site site) {
        super(id, name, site);
    }

    public RealCaptor(String name) {
        super(name);
    }


    public RealCaptor(Site site) {
        super(site);
    }
}
