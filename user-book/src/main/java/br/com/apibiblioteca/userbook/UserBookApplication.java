package br.com.apibiblioteca.userbook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserBookApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserBookApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

    }
}
