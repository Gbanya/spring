import com.yuan.annotation.Component;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-08 09:44
 * @Version 1.0
 **/
public class ReflectAnnotationTest1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射机制怎么获取注解
        //获取类
        Class<?> aClass = Class.forName("com.yuan.bean.User");
        //判断这个类上面有没有指定的注解
        if(aClass.isAnnotationPresent(Component.class)){
            //如果存在，获取类上面的注解
            Component annotation = aClass.getAnnotation(Component.class);
            //访问注解属性
            System.out.println(annotation.value());
        }
    }
}
