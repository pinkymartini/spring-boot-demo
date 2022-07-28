package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean //command line runner, beanlerin hepsini run edecek. yada configurationlar
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",

                    LocalDate.of(2000, JANUARY, 5),
                    "mariamhjamal@gmail.com"
            );

            Student mert = new Student(
                    "Mert",

                    LocalDate.of(2004, JANUARY, 12),
                    "mert@gmail.com"
            );

            repository.saveAll(List.of(mariam,mert));
        };


    }

}
