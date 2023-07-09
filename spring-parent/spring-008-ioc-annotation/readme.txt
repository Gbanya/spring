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

6.属性值注入
    a、@Value
        ·@Value注解可以直接用在属性上，并且不用提供属性的setter方法。
        ·@Value注解也可以用在setter方法上
        ·@Value注解也可以用在构造方法的形参前面,举例：
                public User(@Value{"小明"}) String name,(@Value("23") int age){
                    this.name = name;
                    this.age = age;
                }
         ·@Value注解只是对简单类型属性进行注入
         ·测试方法 IoCAnnotationTest.testDIByAnnotation()

     b、@Autowired和@Qualifier
        ·@Autowired注解可以用来注入非简单类型，被翻译为：自动装配
        ·单独使用@Autowired注解，默认根据类型装配。【默认是ByType】
        ·@Autowired注解可以用在构造方法上、setter方法上、形参上、属性上、注解上
        ·@Autowired注解有一个required属性，默认值是true，表示在注入的时候要求被注入的Bean必须是存在的，如果不存在则报错。
          如果required属性设置为false，表示注入的Bean存在或者不存在都没关系，存在的话就注入，不存在的话也不报错。
        ·如果有多个类型对象可以匹配，那么就需要根据名字进行匹配，此时可以使用@Autowired和@Qualifier联合使用（@Qualifier用来指定名字）。
        ·测试方法 IoCAnnotationTest.testAutowired()

     c、@Resource
        ·@Resource注解也可以完成非简单类型注入
        ·注意，如果使用Spring6，要知道Spring6不再支持JavaEE，它支持的是JaKartaEE9.(Oracle将javaEE贡献给Apache了，Apache将javaEE的名字改为了JaKartaEE了)
        ·测试方法 IoCAnnotationTest.testResource()


     d、@Autowired和@Resource的区别是什么？
        ·@Resource注解是JDK扩展包中的，也就是说属于JDK的一部分，所以该注解是标准注解，更加具有通用性
        ·@Autowired注解是Spring框架自己的。（Spring比较喜欢炫技，@Autowired可以使用的地方很多，花里胡哨）
        ·@Resource注解默认是根据名称装配ByName,注解上未指定name时，会使用属性名作为name查找，如果通过name找不到的话会自动启动通过类型byType装配
        ·@Autowired注解默认根据类型装配ByType,如果想根据名称装配，需要配合@Qualifier注解一起用。
        ·@Resource注解用在属性上、setter方法上
        ·@Autowired注解用在属性上、setter方法上、构造方法上、构造方法参数上

6.全注解开发
    到目前位置，都还需要xml配置文件。我们是使用全注解开发就是不再使用spring配置文件了。怎么实现呢？写一个配置类来代替配置文件。
    测试方法：IoCAnnotationTest.testNoXml()