package ru.academy.springdemo2.model;

import lombok.Builder;
import lombok.Singular;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Builder
//@Entity
@Component
@lombok.Value
public class UsualPerson implements Person {

  //  @Id
  int id = 1;

  String name;

  //  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "country_id")
  Country country;

  int age;

  float height;
  boolean isProgrammer;

  boolean isBroke = false;

  @Singular
  List<String> contacts;

  public UsualPerson(
    @Value("John Smith")
      String name,
    Country country,
    @Value("35")
      int age,
    @Value("1.78")
      float height,
    @Value("true")
      boolean isProgrammer,
    List<String> contacts) {

    this.name = name;
    this.country = country;
    this.age = age;
    this.height = height;
    this.isProgrammer = isProgrammer;
    this.contacts = contacts;
  }

  @Override
  public void sayHello(Person person) {
    System.out.printf("Hello, %s, I'm %s\n", person.getName(), name);
  }
}
