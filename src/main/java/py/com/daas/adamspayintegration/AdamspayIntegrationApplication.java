package py.com.daas.adamspayintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AdamspayIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdamspayIntegrationApplication.class, args);
    }

}
