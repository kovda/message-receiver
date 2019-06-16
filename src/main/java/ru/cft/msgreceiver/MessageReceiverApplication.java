package ru.cft.msgreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.cft.msgreceiver.config.RabbitConfig;
import ru.cft.msgreceiver.config.RabbitMessageConverterConfig;

@SpringBootApplication
public class MessageReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageReceiverApplication.class, args);
	}

}
