package ru.alarh.videomanager

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ConfigurableApplicationContext
import ru.alarh.videomanager.video.properties.TargetGroupProperties

@EnableConfigurationProperties
@SpringBootApplication
class AlarhVideoManagerApplication {

	@Autowired
	TargetGroupProperties prop

	static void main(String[] args) {
		SpringApplication.run(AlarhVideoManagerApplication, args)
//		ConfigurableApplicationContext context = SpringApplication.run(AlarhVideoManagerApplication.class, args)
//		TargetGroupProperties bean = context.getBean(TargetGroupProperties.class)
//		System.out.println(bean.unchecked.source)
	}

}
