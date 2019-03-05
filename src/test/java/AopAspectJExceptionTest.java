import lombok.experimental.FieldDefaults;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.academy.springdemo2.SpringDemo2Application;
import ru.academy.springdemo2.aspects.Bar;
import ru.academy.springdemo2.aspects.CustomerBrokenException;
import ru.academy.springdemo2.model.Person;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertTrue;
import static ru.academy.springdemo2.TestUtils.fromSystemOutPrintln;

@FieldDefaults(level = PRIVATE)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDemo2Application.class)
public class AopAspectJExceptionTest {

  @Autowired
  private Bar bar;

  @Autowired
  private Person customer;

  @Before
  public void setUp() throws Exception {

//        customer.setBroke(true);
  }

  @Test(expected = CustomerBrokenException.class)
  public void testAfterThrowingAdvice() {

    String fromSystemOutPrintln = fromSystemOutPrintln(
      () -> bar.sellSquishee(customer));

    assertTrue("Customer is not broken ",
      fromSystemOutPrintln.contains("Hmmm..."));
  }
}
