import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-25 21:42
 * @Version 1.0
 **/
public class TestReflect {
    public static void main(String[] args) throws Exception {
        // 使用反射机制怎么调用方法。
        // 获取类
        Class<?> aClass = Class.forName("com.yuan.reflect.SomeService");

        // 获取方法
        Method doSome = aClass.getDeclaredMethod("doSome", String.class);

        // 调用方法
        // 四要素：调用哪个对象、哪个方法、传递什么参数、返回什么值
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        doSome.invoke(o,"李四");
        //
    }
}
