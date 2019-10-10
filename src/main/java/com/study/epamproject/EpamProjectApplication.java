package com.study.epamproject;

import com.study.epamproject.controllers.MenuController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EpamProjectApplication implements CommandLineRunner {
	private final MenuController menuController;
	private static Logger LOG = LogManager.getLogger(EpamProjectApplication.class);

	public EpamProjectApplication(MenuController menuController) {
		this.menuController = menuController;
	}

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(EpamProjectApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");
		menuController.start();
	}
}
