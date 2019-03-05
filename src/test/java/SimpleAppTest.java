import lombok.experimental.FieldDefaults;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertEquals;

@FieldDefaults(level = PRIVATE)
public class SimpleAppTest {

  static final String IOC_XML =
    "ioc.xml";

  BeanFactory context = new ClassPathXmlApplicationContext(IOC_XML);

  @Test
  public void testInitPerson() {
    assertEquals(HelloWorldTest
                   .getExpectedPerson(),
      context.getBean("person"));
  }
}
