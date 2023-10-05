package com.ysun60.moviemeta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ysun60.moviemeta.subpackages"})
public class MovieMetaApplication {
    public static void main(String[] args) {

        SpringApplication.run(MovieMetaApplication.class, args);

    }

}
