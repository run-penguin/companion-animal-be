package com.companion_animal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// exclude는 jpa 때문에 빌드가 안되서 추가해둠. db 연결할 때 지울것
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CompanionAnimalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanionAnimalApplication.class, args);
	}

}
