package ru.academy.springdemo2.aspects;

import lombok.experimental.FieldDefaults;
import ru.academy.springdemo2.model.Person;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class ApuBar implements Bar {

  @Override
  public Squishee sellSquishee(Person customer)  {
    if (customer.isBroke())
      throw new CustomerBrokenException();

    System.out.println("Here is your Squishee");
    return new Squishee("Usual Squishee");
  }
}
