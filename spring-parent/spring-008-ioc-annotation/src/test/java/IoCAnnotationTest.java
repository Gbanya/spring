import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-08 14:26
 * @Version 1.0
 **/
public class IoCAnnotationTest {

    @Test
    public void testChoose(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");

    }

    @Test
    public void testBeanComponent(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }
}
