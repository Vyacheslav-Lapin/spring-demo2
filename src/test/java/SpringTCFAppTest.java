import lombok.experimental.FieldDefaults;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.academy.springdemo2.model.UsualPerson;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@FieldDefaults(level = PRIVATE)
@ContextConfiguration("classpath:ioc.xml")
public class SpringTCFAppTest {

  @Autowired
  UsualPerson person;

  @Test
  public void testInitPerson() {
    assertEquals(HelloWorldTest.getExpectedPerson(), person);
  }
}
