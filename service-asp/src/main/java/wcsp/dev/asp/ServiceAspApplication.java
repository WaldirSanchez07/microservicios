package wcsp.dev.asp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceAspApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAspApplication.class, args);
	}

}
