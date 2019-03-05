package ru.academy.springdemo2.model;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;

@Value
@Builder
public class Country {

  @Default
  int id = 1;

  String name;

  String codeName;
}

