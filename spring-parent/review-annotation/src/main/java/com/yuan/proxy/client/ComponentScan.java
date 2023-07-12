package com.yuan.proxy.client;

import com.yuan.proxy.annotation.Component;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @description: 扫描某个包下所有的类，当类上有@Component注解的时候，实例化该对象，然后放到Map集合中。
 * @author: gbanya
 * @create: 2023-07-08 10:41
 * @Version 1.0
 **/
public class ComponentScan {
    public static void main(String[] args) {
        // 给定某个包的路径，要求扫描这个包下所有的类。当类上有@Component注解的时候，实例化该对象，然后放到Map集合中。
        String packageName="com.yuan.bean";

        // 创建Map对象，用来存放Bean对象
        HashMap<String, Object> beanMap = new HashMap<>();

        // 开始扫描程序
        // . 这个正则表达式代表任意字符。这里的“.”必须是一个普通的"."字符，不能是正则表达式中的"."
        // 在正则表达式中怎么表示一个普通的“.”字符呢？使用"\."正则表达式代表一个普通的"."字符
        String packagePath= packageName.replaceAll("\\.","/");
        System.out.println("packagePath = " + packagePath);
        // com是在类的根路径下的一个目录，所以使用系统类加载器ClassLoader.getSystemClassLoader(),（系统类加载器自动从类的根路径下加载资源）
        URL resource = ClassLoader.getSystemClassLoader().getResource(packagePath);
        System.out.println("resource = " + resource);
        // 获取这个包的绝对路径
        String path = resource.getPath();
        System.out.println("path = " + path);
        // 获取一个绝对路径下的所有文件，file对象指向文件目录
        File file = new File(path);
        System.out.println("file = " + file);
        // 获取文件目录下的所有子文件
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f ->{
            try {
                System.out.println("f = " + f);
                System.out.println("f.getName = " + f.getName());
                // split的参数regex ，全名为  regular expression（正则表达式）
                String beanName = f.getName().split("\\.")[0];
                System.out.println("beanName = " + beanName);
                // 获取包下所有类的全类名
                String className = packageName + "." + beanName;
                System.out.println("className = " + className);

                // 通过反射机制解析注解
                Class<?> aClass = Class.forName(className);
                // 判断类上是否有@Component这个注解
                if(aClass.isAnnotationPresent(Component.class)){
                    // 获取注解
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    // 创建对象
                    Constructor<?> constructor = aClass.getConstructor();
                    Object object = constructor.newInstance();
                    // 将创建的对象存放到beanMap集合中
                    beanMap.put(id,object);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("beanMap = " + beanMap);

    }
}
