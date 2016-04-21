package com.icap.primenumber.service;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.xml.ws.Service;

public class PrimeNumberApplication extends Application<PrimeNumberConfiguration> {

    ApplicationContext context;

    public static void main(String[] args) throws Exception {
        new PrimeNumberApplication().run(args);
    }

    @Override
    public String getName() {
        return "PrimeNumbers";
    }

    @Override
    public void initialize(Bootstrap<PrimeNumberConfiguration> bootstrap) {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Override
    public void run(PrimeNumberConfiguration configuration, Environment environment) {
        PrimeNumberService primeNumberService = (PrimeNumberService) context.getBean("service");
        environment.jersey().register(primeNumberService);
    }

}
