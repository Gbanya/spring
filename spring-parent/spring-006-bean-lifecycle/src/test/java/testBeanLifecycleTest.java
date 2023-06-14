import com.yuan.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-14 22:03
 * @Version 1.0
 **/
public class testBeanLifecycleTest {

    @Test
    public void testBeanLifecycleFive(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println("第四步：使用Bean： "+userBean);
        System.out.println(userBean);

        //注意：必须手动关闭spring容器，这样spring才会销毁Bean
        applicationContext.close();
    }
}
