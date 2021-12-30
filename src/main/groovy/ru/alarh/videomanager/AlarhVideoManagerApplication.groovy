package ru.alarh.videomanager

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@EnableConfigurationProperties
@SpringBootApplication
class AlarhVideoManagerApplication {

	static void main(String[] args) {
		SpringApplication.run(AlarhVideoManagerApplication, args)
	}

}
