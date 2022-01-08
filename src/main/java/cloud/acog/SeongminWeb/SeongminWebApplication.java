package cloud.acog.SeongminWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SeongminWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeongminWebApplication.class, args);
	}

}
