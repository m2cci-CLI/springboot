package com.training.springcore.bigcorp.service;


import com.training.springcore.bigcorp.repository.CaptorDao;
import com.training.springcore.bigcorp.model.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.springcore.bigcorp.service.measure.MeasureService;


import java.util.Set;
import java.util.stream.Collectors;

@Service("captorService")
public class CaptorServiceImpl implements CaptorService{

    @Autowired
   private CaptorDao captorDao;
    @Autowired
    private MeasureService fixedMeasureService;
    @Autowired
    private MeasureService realMeasureService;

    @Autowired
    private MeasureService simulatedMeasureService;

    public CaptorServiceImpl(CaptorDao captorDao, MeasureService fixedMeasureService, MeasureService realMeasureService, MeasureService simulatedMeasureService) {
        this.captorDao = captorDao;
        this.fixedMeasureService = fixedMeasureService;
        this.realMeasureService = realMeasureService;
        this.simulatedMeasureService = simulatedMeasureService;
    }

    public CaptorDao getCaptorDao() {
        return captorDao;
    }

    public void setCaptorDao(CaptorDao captorDao) {
        this.captorDao = captorDao;
    }

    public MeasureService getFixedMeasureService() {
        return fixedMeasureService;
    }

    public void setFixedMeasureService(MeasureService fixedMeasureService) {
        this.fixedMeasureService = fixedMeasureService;
    }

    public MeasureService getRealMeasureService() {
        return realMeasureService;
    }

    public void setRealMeasureService(MeasureService realMeasureService) {
        this.realMeasureService = realMeasureService;
    }

    public MeasureService getSimulatedMeasureService() {
        return simulatedMeasureService;
    }

    public void setSimulatedMeasureService(MeasureService simulatedMeasureService) {
        this.simulatedMeasureService = simulatedMeasureService;
    }

    @Override
    public Set<Captor> findBySite(String siteId) {

        return captorDao.findBySiteId(siteId).stream().collect(Collectors.toSet());
    }
}
