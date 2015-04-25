package ro.chronos.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.chronos.dao.IBookRepository;
import ro.chronos.dao.impl.InMemoryBookRepository;

/**
 * Spring Boot main runner.
 * <p/>
 * Created by alexandrumacavei on 25.04.15.
 */
@SpringBootApplication
public class BootApplication {

    @Bean
    public IBookRepository getBookRepository() {
        return new InMemoryBookRepository();
    }

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
