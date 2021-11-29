package wcsp.dev.desktop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceDesktopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDesktopApplication.class, args);
	}

}
