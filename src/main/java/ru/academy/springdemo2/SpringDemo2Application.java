package ru.academy.springdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import ru.academy.springdemo2.model.Country;
import ru.academy.springdemo2.model.Person;
import ru.academy.springdemo2.model.UsualPerson;

import java.util.List;

@SpringBootApplication
@ImportResource("classpath*:ioc.xml")
public class SpringDemo2Application {

  public static void main(String... args) {
    SpringApplication.run(SpringDemo2Application.class, args);
  }

  @Bean
  Person person(Country country, List<String> contacts) {
    //noinspection unchecked
    return UsualPerson.builder()
             .age(35)
             .height(1.78F)
             .isProgrammer(true)
             .name("John Smith")
             .country(country)
             .contacts(contacts)
             .build();
  }

  @Bean
  List<String> contacts() {
      return List.of("asd@asd.ru", "+7-234-456-67-89");
  }
}
