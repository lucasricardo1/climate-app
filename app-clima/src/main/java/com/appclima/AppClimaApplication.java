package com.appclima;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Locale;
import java.util.TimeZone;



@SpringBootApplication
@ComponentScan(basePackages = {"com.appclima"})
public class AppClimaApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return configureApplication(builder);
	}
	public static void main(String[] args) {
		configureApplication(new SpringApplicationBuilder()).run(args);
	}
	/**
	 * Configuração do modo da aplicação
	 *
	 * @param builder
	 * @return
	 */
	private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
		Locale.setDefault(new Locale("pt", "BR"));
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		return builder.sources(AppClimaApplication.class);
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
		return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder //
				.setConnectTimeout(Duration.ofSeconds(3)) //
				.setReadTimeout(Duration.ofSeconds(1)) //
				.build();
	}

}


