package lk.docker.practice;

import lk.docker.practice.serviceImpl.DataIngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {
	static  DataIngestionService dataIngestionService;

	@Autowired
	DataIngestionService dataIngestionService1;



	@PostConstruct
	private void init() {
		dataIngestionService = this.dataIngestionService1;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		dataIngestionService.ingestData();
	}

}
