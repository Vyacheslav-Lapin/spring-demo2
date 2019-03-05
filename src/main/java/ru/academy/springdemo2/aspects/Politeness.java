package ru.academy.springdemo2.aspects;

import lombok.experimental.FieldDefaults;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import ru.academy.springdemo2.model.Person;

import static lombok.AccessLevel.PRIVATE;

@Aspect
@Service
@FieldDefaults(level = PRIVATE)
public class Politeness {

  @Pointcut("execution(* sellSquishee(..))")
  public void sellSquishee() {
  }

  @Before("sellSquishee()")
  public void sayHello(JoinPoint joinPiont) {
    System.out.println("Hello " + ((Person) joinPiont.getArgs()[0]).getName() + ". How are you doing? \n");
  }

  @AfterReturning(
    pointcut = "execution(* sellSquishee(..))",
    returning = "retVal")
  public void askOpinion(Drink retVal) {
    System.out.println("Is " + retVal.getName() + " Good Enough? \n");
  }

  public void sayYouAreNotAllowed() {
    System.out.println("Hmmm... \n");
  }

  public void sayGoodBye() {
    System.out.println("Good Bye! \n");
  }

  public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("Hi! \n");
    Object retVal = pjp.proceed();
    System.out.println("See you! \n");
    return retVal;
  }

}
