package ru.academy.springdemo2.model;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
//@Entity
@FieldDefaults(level = PRIVATE)
public class UsualPerson implements Person {

//  @Id
  int id;

  String name;

//  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "country_id")
  Country country;

  int age;
  float height;
  boolean isProgrammer;

  List<String> contacts;

  @Override
  public void sayHello(Person person) {
    System.out.printf("Hello, %s, I'm %s\n", person.getName(), name);
  }
}
