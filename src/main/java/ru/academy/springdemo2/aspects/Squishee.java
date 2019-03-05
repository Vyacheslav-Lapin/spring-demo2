package ru.academy.springdemo2.aspects;

import lombok.Value;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Value
@FieldDefaults(level = PRIVATE)
public class Squishee implements Drink {

  String name;
}
