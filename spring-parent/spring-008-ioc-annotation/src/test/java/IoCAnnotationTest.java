import com.yuan.spring6.bean.MyDataSource;
import com.yuan.spring6.config.Spring6Config;
import com.yuan.spring6.dao.OrderService;
import com.yuan.spring6.resource.StudentService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-08 14:26
 * @Version 1.0
 **/
public class IoCAnnotationTest {


    @Test
    public void testBeanComponent(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }


    @Test
    public void testChoose(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");

    }

    @Test
    public void testDIByAnnotation(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource.toString());
    }

    @Test
    public void testAutowired(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testResource(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }

    @Test
    public void testNoXml(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);

    }
}
