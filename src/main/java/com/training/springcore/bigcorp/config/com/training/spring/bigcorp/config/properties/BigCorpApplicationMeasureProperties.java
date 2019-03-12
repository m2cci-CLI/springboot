package com.training.springcore.bigcorp.config.com.training.spring.bigcorp.config.properties;

import com.training.springcore.bigcorp.service.measure.FixedMeasureService;
import com.training.springcore.bigcorp.service.measure.RealMeasureService;
import com.training.springcore.bigcorp.service.measure.SimulatedMeasureService;
import org.springframework.beans.factory.annotation.Autowired;

public class BigCorpApplicationMeasureProperties {

    private Integer defaultFixed;

    private Integer defaultSimulated;

    private Integer defaultReal;

    public Integer getDefaultFixed() {
        return defaultFixed;
    }

    public void setDefaultFixed(Integer defaultFixed) {
        this.defaultFixed = defaultFixed;
    }

    public Integer getDefaultSimulated() {
        return defaultSimulated;
    }

    public void setDefaultSimulated(Integer defaultSimulated) {
        this.defaultSimulated = defaultSimulated;
    }

    public Integer getDefaultReal() {
        return defaultReal;
    }

    public void setDefaultReal(Integer defaultReal) {
        this.defaultReal = defaultReal;
    }
}
