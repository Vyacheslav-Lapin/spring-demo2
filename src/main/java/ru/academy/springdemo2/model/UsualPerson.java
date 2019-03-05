package ru.academy.springdemo2.model;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
//@Entity
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

  @Override
  public void sayHello(Person person) {
    System.out.printf("Hello, %s, I'm %s\n", person.getName(), name);
  }
}
