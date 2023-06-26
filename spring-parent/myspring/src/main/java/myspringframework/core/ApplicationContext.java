package myspringframework.core;

/**
 * @description: MySpring框架应用上下文接口
 * @author: gbanya
 * @create: 2023-06-26 20:41
 * @Version 1.0
 **/
public interface ApplicationContext {
    /*
    *   根据bean的名称获取对应的bean对象
    *   beanName: myspring配置文件中bean标签的id
    *   return： 对应的bean对象
    * */
    Object getBean(String beanName);
}
