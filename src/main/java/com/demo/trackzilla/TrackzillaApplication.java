package com.demo.trackzilla;

import com.demo.trackzilla.entity.Application;
import com.demo.trackzilla.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrackzillaApplication {

	private static final Logger log = LoggerFactory.getLogger(TrackzillaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TrackzillaApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(ApplicationRepository repository) {
//		return (args) -> {
//			repository.save(new Application("Trackzilla","kesha.williams","Application for tracking bugs."));
//			repository.save(new Application("Expenses","mary.jones","Application to track expense reports."));
//			repository.save(new Application("Notifications","karen.kane","Application to send alerts and notifications to users."));
//
//			for (Application application : repository.findAll()) {
//				log.info("The application is: " + application.toString());
//			}
//		};
//	}

}
