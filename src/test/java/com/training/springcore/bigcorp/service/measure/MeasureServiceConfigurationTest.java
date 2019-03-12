package com.training.springcore.bigcorp.service.measure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.training.springcore.bigcorp.service.measure", "com.training.springcore.bigcorp.config.properties"})
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties
public class MeasureServiceConfigurationTest {
}
