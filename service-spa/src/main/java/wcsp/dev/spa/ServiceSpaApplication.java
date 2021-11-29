package wcsp.dev.spa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceSpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSpaApplication.class, args);
	}

}
