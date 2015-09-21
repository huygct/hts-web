package com.huyvn.happytostudy.main;

import com.huyvn.happytostudy.services.UserService;
import com.huyvn.happytostudy.services.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* Small MongoDB application that uses spring data to interact with MongoDB.
*
* @author Jeroen Reijn
*/
public class MongoDBApp {

    static final Logger logger = LoggerFactory.getLogger(MongoDBApp.class);

    public static void main( String[] args ) {
		logger.info("Bootstrapping MongoDemo application");

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");

        UserService userService = context.getBean(UserServiceImpl.class);

        System.out.printf("---demo---" + userService.findAll());
	}
}
