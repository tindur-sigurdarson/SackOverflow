package is.hi.hpv501.sack.SackOverflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SackOverflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SackOverflowApplication.class, args);
	}

}
