package com.prahlad.SpringBoot02;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.prahlad.SpringBoot02.service.AmazonService;

@SpringBootApplication
public class SpringbootBasicDay2Application 
{

    public static void main(String[] args) 
    {

        ApplicationContext context =
                SpringApplication.run(SpringbootBasicDay2Application.class, args);

        AmazonService amazon = context.getBean(AmazonService.class);

        amazon.processOrder(5454.4);
    }
}