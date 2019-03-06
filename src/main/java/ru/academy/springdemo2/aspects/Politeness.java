package ru.academy.springdemo2.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import ru.academy.springdemo2.model.Person;

@Aspect
@Service
public class Politeness {

  @Pointcut("execution(* sellSquishee(ru.academy.springdemo2.model.Person))")
  public void sellSquishee() {
  }

  @Before("sellSquishee() && args(person)")
  public void sayHello(Person person) {
    System.out.printf("Hello %s. How are you doing?\n", person.getName());
  }

  @AfterReturning(
    pointcut = "sellSquishee()",
    returning = "drink")
  public void askOpinion(Drink drink) {
    System.out.printf("Is %s Good Enough?\n", drink.getName());
  }

  @AfterThrowing("sellSquishee()")
  public void sayYouAreNotAllowed() {
    System.out.println("Hmmm...");
  }

  @After("sellSquishee()")
  public void sayGoodBye() {
    System.out.println("Good Bye!");
  }

  @Around("sellSquishee()")
  public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("Hi!");
    Object retVal = pjp.proceed();
    System.out.println("See you!");
    return retVal;
  }

}
