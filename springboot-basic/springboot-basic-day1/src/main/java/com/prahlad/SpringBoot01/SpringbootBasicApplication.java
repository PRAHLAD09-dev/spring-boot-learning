package com.prahlad.SpringBoot01;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.prahlad.SpringBoot01.service.GreetingsServices;

@SpringBootApplication
public class SpringbootBasicApplication 
{

	public static void main(String[] args) 
	{
		 ConfigurableApplicationContext container = SpringApplication.run(SpringbootBasicApplication.class, args);
		 
		  GreetingsServices greet = container.getBean(GreetingsServices.class);
		   String status = greet.generateWish("Prahlad");
		  
			   System.out.println(status);
	}

}
