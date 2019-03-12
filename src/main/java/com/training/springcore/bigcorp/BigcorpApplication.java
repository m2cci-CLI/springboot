package com.training.springcore.bigcorp;
import com.training.springcore.bigcorp.config.com.training.spring.bigcorp.config.properties.BigCorpApplicationProperties;
import com.training.springcore.bigcorp.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class BigcorpApplication {
	private final static Logger logger = LoggerFactory.getLogger(SiteService.class);
	public static void main(String[] args) {



		ApplicationContext context = SpringApplication.run(BigcorpApplication.class,
				args);
		BigCorpApplicationProperties bigCorpApplicationProperties = context.getBean(BigCorpApplicationProperties.class);

		logger.info("================================================================== ======");
		logger.info("Application [" + bigCorpApplicationProperties.getName() + "] - version: " + bigCorpApplicationProperties.getVersion());
		logger.info("plus d'informations sur " +
				bigCorpApplicationProperties.getWebSiteUrl());
		logger.info("================================================================== ======");
		context.getBean(SiteService.class).findById("test");
	}
}
