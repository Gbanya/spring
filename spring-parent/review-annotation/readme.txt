1.自定义一个Component注解
2.注解生效范围：
    ·RetentionPolicy.SOURCE表示@Component注解只保留在.java文件中，编译后的class文件不存在了。
    ·RetentionPolicy.CLASS表示@Component注解可以保留在.java文件中，并且编译后的class文件中也存在。
    ·RetentionPolicy.RUNTIME表示@Component注解最终保留在class文件中，并且可以被反射机制读取。
3.测试方法：
    ReflectAnnotationTest1

4. 给定一个包路径，扫描该包下所有的类，并且只有@Component注解的类才创建对象（这个其实就是@ComponentScan注解的原理）
    实现代码：com.yuan.client.ComponentScan