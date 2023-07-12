import com.yuan.spring6.bean.Student;
import com.yuan.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-14 22:03
 * @Version 1.0
 **/
public class testBeanLifecycleTest {

    /**
     * Spring容器只会对singleton的Bean进行完整的生命周期管理。
     * 如果是prototype作用域的Bean，Spring容器只负责将该Bean初始化完毕，等客户端程序一旦获取到该Bean之后，Spring容器就不再管理该对象的生命周期了，销毁的步骤就不会自动执行了。
     */
    @Test
    public void testBeanLifecycleFive(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println("第八步：使用Bean： "+userBean);

        //注意：必须手动关闭spring容器，这样spring才会销毁Bean
        applicationContext.close();
    }


    @Test
    public void testRegisterBean(){
        //自己new的对象
        Student student = new Student();
        System.out.println(student);

        //将以上自己new的这个对象纳入Spring容器管理。半路上交给Spring来管理。
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerSingleton("studentBean",student);

        //从Spring容器中获取
        Student studentBean = defaultListableBeanFactory.getBean("studentBean", Student.class);
        System.out.println(studentBean);
    }
}
