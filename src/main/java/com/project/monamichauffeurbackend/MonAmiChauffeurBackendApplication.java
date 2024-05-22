package com.project.monamichauffeurbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MonAmiChauffeurBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonAmiChauffeurBackendApplication.class, args);
	}

}
