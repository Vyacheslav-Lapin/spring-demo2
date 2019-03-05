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

  static UsualPerson getExpectedPerson() {
    return UsualPerson.builder()
             .age(35)
             .height(1.78F)
             .isProgrammer(true)
             .name("John Smith")
             .country(Country.builder()
                        .name("Russia")
                        .codeName("RU")
                        .build())
             .contact("asd@asd.ru")
             .contact("+7-234-456-67-89")
             .build();
  }
}
