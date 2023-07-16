import com.yuan.service.UserService;
import com.yuan.service.config.SpringAopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-16 15:12
 * @Version 1.0
 **/
public class SpringAopTest {
    @Test
    public void testAround(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();
    }

    @Test
    public void testNoXml(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAopConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();

    }
}
