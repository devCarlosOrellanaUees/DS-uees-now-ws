package ec.edu.uees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan("ec.edu.uees.entities")
@EnableScheduling
public class DsUeesNowWsApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DsUeesNowWsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DsUeesNowWsApplication.class);
    }
}