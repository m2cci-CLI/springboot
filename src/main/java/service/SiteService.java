package service;

import com.training.springcore.model.Site;

public interface SiteService {
    Site findById(String siteId);

    void readFile(String path);
}