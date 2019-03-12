package com.training.springcore.bigcorp.config.com.training.spring.bigcorp.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@ConfigurationProperties(prefix = "bigcorp")

public class BigCorpApplicationProperties {

    private String name;
    private Set<String> emails;

    private String webSiteUrl;
    private Integer version;

    @NestedConfigurationProperty
    private BigCorpApplicationMeasureProperties measure;

    public BigCorpApplicationMeasureProperties getMeasure() {
        return measure;
    }

    public void setMeasure(BigCorpApplicationMeasureProperties measure) {
        this.measure = measure;
    }

    public BigCorpApplicationProperties(String name, Set<String> emails, String webSiteUrl, Integer version) {
        this.name = name;
        this.emails = emails;
        this.webSiteUrl = webSiteUrl;
        this.version = version;
    }

    public BigCorpApplicationProperties() {

    }

    public String getName() {
        return name;
    }

    public Integer getVersion() {
        return version;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "BigCorpApplicationProperties{" +
                "name='" + name + '\'' +
                ", version=" + version +
                ", emails=" + emails +
                ", webSiteUrl='" + webSiteUrl + '\'' +
                '}';
    }
}
