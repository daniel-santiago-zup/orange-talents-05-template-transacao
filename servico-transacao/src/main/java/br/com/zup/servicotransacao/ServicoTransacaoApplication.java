package br.com.zup.servicotransacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class ServicoTransacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicoTransacaoApplication.class, args);
	}

	@Bean
	JsonMessageConverter jsonMessageConverter() {
		return new JsonMessageConverter();
	}

}
