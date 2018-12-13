package com.coding2d.EncryptionProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication

//disable spring security
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class EncryptionProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncryptionProviderApplication.class, args);
	}
}
