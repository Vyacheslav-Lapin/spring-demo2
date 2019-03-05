import lombok.experimental.FieldDefaults;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.academy.springdemo2.model.Country;
import ru.academy.springdemo2.model.UsualPerson;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertEquals;

@FieldDefaults(level = PRIVATE)
public class HelloWorldTest {

  static final String APPLICATION_CONTEXT_XML_FILE_NAME = "ioc.xml";

  UsualPerson expectedPerson = getExpectedPerson();

  BeanFactory context = new ClassPathXmlApplicationContext(
    APPLICATION_CONTEXT_XML_FILE_NAME);

  @Test
  public void testInitPerson() {
    assertEquals(expectedPerson, context.getBean("person"));
  }

  @SuppressWarnings("WeakerAccess")
  UsualPerson getExpectedPerson() {
    return new UsualPerson()
             .setAge(35)
             .setName("John Smith")
             .setCountry(new Country()
                           .setId(1)
                           .setName("Russia")
                           .setCodeName("RU"));
  }
}
