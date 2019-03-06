import lombok.experimental.FieldDefaults;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.academy.springdemo2.SpringDemo2Application;
import ru.academy.springdemo2.TestUtils;
import ru.academy.springdemo2.aspects.Bar;
import ru.academy.springdemo2.aspects.CustomerBrokenException;
import ru.academy.springdemo2.model.Person;
import ru.academy.springdemo2.model.UsualPerson;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertTrue;

@FieldDefaults(level = PRIVATE)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDemo2Application.class)
public class AopAspectJExceptionTest {

  @Autowired
  Bar bar;

  @Autowired
  Person person;

  @Before
  public void setUp() {
    person = person.withBroke(true);
  }

  @Test(expected = CustomerBrokenException.class)
  public void testAfterThrowingAdvice() {
    bar.sellSquishee(person);
    // TODO: 2019-03-06 check sout
  }
}
