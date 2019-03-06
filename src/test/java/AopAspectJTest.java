import lombok.experimental.FieldDefaults;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.academy.springdemo2.SpringDemo2Application;
import ru.academy.springdemo2.TestUtils;
import ru.academy.springdemo2.aspects.ApuBar;
import ru.academy.springdemo2.aspects.Bar;
import ru.academy.springdemo2.model.Person;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
@FieldDefaults(level = PRIVATE)
@ContextConfiguration(classes = SpringDemo2Application.class)
public class AopAspectJTest {

  @Autowired
  Bar bar;

  @Autowired
  Person customer;

  String out;

  @Before
  public void setUp() {
    out = TestUtils.fromSystemOutPrintln(
      () -> bar.sellSquishee(customer));
  }

  @Test
  public void testBeforeAdvice() {
    assertTrue("Before advice is not good enough...", out.contains("Hello"));
    assertTrue("Before advice is not good enough...", out.contains("How are you doing?"));

  }

  @Test
  public void testAfterAdvice() {
    assertTrue("After advice is not good enough...", out.contains("Good Bye!"));
  }

  @Test
  public void testAfterReturningAdvice() {
    assertTrue("Customer is broken", out.contains("Good Enough?"));
  }

  @Test
  public void testAroundAdvice() {
    assertTrue("Around advice is not good enough...", out.contains("Hi!"));
    assertTrue("Around advice is not good enough...", out.contains("See you!"));
  }

  @Test
  public void testAllAdvices() {
    assertTrue("barObject instanceof ApuBar", bar instanceof ApuBar);
//    System.out.println(bar.getClass());
  }
}
