import com.powernode.myspring.bean.UserService;
import myspringframework.core.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-26 20:59
 * @Version 1.0
 **/
public class MySpringTest {
    @Test
    public void testMySpring(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.save();
    }
}
