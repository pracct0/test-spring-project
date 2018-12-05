package com.kim.app;

import org.jboss.logging.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApplicationMainClass implements ApplicationRunner, CommandLineRunner {

	private static Logger logger = Logger.getLogger(ApplicationMainClass.class.getName());

	public static void main(String[] args) {

		SpringApplication.run(ApplicationMainClass.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		logger.debug("#####::Application Runner.");
	}

	@Override
	public void run(String... args) throws Exception {

		logger.debug("#####::CommandLine Runner.");
	}
}
