package br.com.iesp.full.stack.serviceHere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.iesp.full.stack.entidades")
public class ServiceHereApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHereApplication.class, args);
	}	

}
