package GCS.GCS_Eureka_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer


@SpringBootApplication
public class GcsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcsEurekaServerApplication.class, args);
	}

}
