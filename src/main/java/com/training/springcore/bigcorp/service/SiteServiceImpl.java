package com.training.springcore.bigcorp.service;


import com.training.springcore.bigcorp.model.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;




@Service("siteService")
@Component
public class SiteServiceImpl  implements SiteService{

    private final static Logger logger = (Logger) LoggerFactory.getLogger(SiteService.class);


    private CaptorService captorService;

    @Autowired
    private ResourceLoader resourceLoader;

    public SiteServiceImpl(){

    }


    @Autowired
    public SiteServiceImpl(CaptorService captorService){
        logger.info("Appel de findById avec id {}",this);
       // System.out.println("Init SiteServiceImpl :" + this);
        this.captorService = captorService;
    }

    @Override
    @Monitored
    public Site findById(String siteId) {
        System.out.println("Appel de findById :" + this);
        if (siteId == null) {
            return null;
        }

        Site site = new Site("capteur de position");
        site.setId(siteId);
        site.setCaptors(captorService.findBySite(siteId));
        return site;
    }


}
