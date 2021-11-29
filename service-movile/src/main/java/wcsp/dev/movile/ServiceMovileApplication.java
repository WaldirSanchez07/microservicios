package wcsp.dev.movile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceMovileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMovileApplication.class, args);
	}

}
