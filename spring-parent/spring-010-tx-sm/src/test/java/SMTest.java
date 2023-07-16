import com.yuan.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-16 18:59
 * @Version 1.0
 **/
public class SMTest {

    @Test
    public void testSM(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
        try{
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转账成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
