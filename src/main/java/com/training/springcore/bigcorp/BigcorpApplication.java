package com.training.springcore.bigcorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BigcorpApplication {

	public static void main (String[] args){
		BigcorpApplication application = new BigcorpApplication();
		application.run();
	}
	public void run(){
		System.out.println("Application startup");
	}

}

