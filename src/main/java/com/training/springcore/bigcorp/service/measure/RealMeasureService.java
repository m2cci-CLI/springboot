package com.training.springcore.bigcorp.service.measure;


import com.training.springcore.bigcorp.config.com.training.spring.bigcorp.config.properties.BigCorpApplicationProperties;
import com.training.springcore.bigcorp.model.Captor;
import com.training.springcore.bigcorp.model.Measure;
import com.training.springcore.bigcorp.model.MeasureStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Service("realMeasureService")
public class RealMeasureService implements MeasureService {

    @Autowired
    private BigCorpApplicationProperties properties;

    @Override
    public List<Measure> readMeasures(Captor captor, Instant start, Instant end, MeasureStep step) {
        checkReadMeasuresAgrs(captor,start,end,step);
        List<Measure> measures = new ArrayList<>();
        Instant current = start;
        while(current.isBefore(end)){
            measures.add(new Measure(current, properties.getMeasure().getDefaultReal(), captor));
            current = current.plusSeconds(step.getDurationInSecondes());
        }
        return measures;
    }
}
