import com.yuan.proxy.spring6.bean.Husband;
import com.yuan.proxy.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-25 20:55
 * @Version 1.0
 **/
public class CircularDependencyTest {

    @Test
    public void tsetCD(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        System.out.println(husbandBean);
        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(wifeBean);
    }
}
