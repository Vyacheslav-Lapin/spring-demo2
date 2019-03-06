package ru.academy.springdemo2.aspects;

import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.academy.springdemo2.model.Person;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE)
public class ApuBar implements Bar {

  @Override
  public Squishee sellSquishee(ApuBar this, Person person)  {
    if (person.isBroke())
      throw new CustomerBrokenException();

    System.out.println("Here is your Squishee");
    return new Squishee("Usual Squishee");
  }
}
