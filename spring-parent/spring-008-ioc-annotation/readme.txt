1.负责声明Bean的注解，常用的包括4个：
    ·@Component
    ·@Controller
    ·@Service
    ·@Repository
    这4个注解的value可以不设定值，Spring框架会将类名转为小驼峰作为Bean对象的名字id

2.@Controller、@Service、@Repository实际上都是@Component注解的别名：
    举例：public @interface Controller {
           @AliasFor(
               annotation = Component.class
           )
           String value() default "";
       }

3.如何使用以上的注解？
    第一步：加入aop的依赖
    第二步：在配置文件中添加context命名空间
    第三步：在配置文件中指定扫描的包
    第四步：在Bean类上使用注解

4.简单版，使用注解+配置文件扫描的方式
    测试方法：IoCAnnotationTest.testBeanComponent()方法

5.我们在某个包下，选择性实例化某个注解注释的类，该怎么做呢？
    测试方法：IoCAnnotationTest.testChoose()方法

注意：
    ·@Component、@Controller、@Service、@Repository四个注解只是实例化bean对象，此时还没有对属性的值进行注入
    ·对属性的值进行注入，可以选择@Value、@Autowired+@Qualifier、@Resource注解


