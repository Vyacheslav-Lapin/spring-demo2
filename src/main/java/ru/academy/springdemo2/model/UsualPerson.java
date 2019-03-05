package ru.academy.springdemo2.model;

import lombok.Builder;
import lombok.Builder.Default;
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
  @Default
  int id = 1;

  String name;

  //  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "country_id")
  Country country;

  int age;

  float height;
  boolean isProgrammer;

  @Singular
  List<String> contacts;

  public UsualPerson(
    @Value("1")
      int id,
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

    this.id = id;
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
