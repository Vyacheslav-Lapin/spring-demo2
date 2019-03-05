package ru.academy.springdemo2.model;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyBean implements ApplicationListener {
  public void onApplicationEvent(ApplicationEvent event) {
    //...
  }
}
