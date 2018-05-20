package com.onion.message;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MessageApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MessageApplication.class, args);
		ServerLauncherImpl.getInstance().startup();
	}
}
