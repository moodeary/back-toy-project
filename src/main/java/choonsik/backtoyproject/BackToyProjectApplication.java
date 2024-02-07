package choonsik.backtoyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BackToyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackToyProjectApplication.class, args);
	}


}
