package service.measure;


import model.Captor;
import model.Measure;
import model.MeasureStep;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service("fixedMeasureService")

public class FixedMeasureService implements MeasureService {

    @Value("${bigcorp.measure.default-fixed}")
    private Integer defaultMeasure;

    @Override
    public List<Measure> readMeasures(Captor captor, Instant start, Instant end, MeasureStep step) {
        checkReadMeasuresAgrs(captor,start,end,step);
        List<Measure> measures = new ArrayList<>();
        Instant current = start;
        while(current.isBefore(end)){
            measures.add(new Measure(current, defaultMeasure, captor));
            current = current.plusSeconds(step.getDurationInSecondes());
        }
        return measures;
    }
}
