Bean的实例化方式（可以理解为在Spring框架中有哪些Bean的获取方式）:
第一种：通过构造方法实例化
第二种：通过简单工厂模式实例化
第三种：通过factory-bean实例化（工厂方法模式）
第四种：通过FactoryBean接口实例化

第二、三、四种方法最底层还是调用的构造方法来创建对象。

1.通过构造方法实例化（测试方法：testInstantiation1()）
    默认情况下，会调用Bean的无参构造方法。

2.通过简单工厂模式实例化（测试方法：testInstantiation2()）
    a、最底层其实还是用的构造方法创建的对象。
    b、工厂类中的方法必须是静态方法，否则报错：No matching factory method found on class [com.yuan.spring6.bean.StarFactory]: factory method 'getStar()

3.通过factory-bean实例化（测试方法：testInstantiation3()）
    a、和简单工厂模式实例化方法不同，通过factory-bean实例化中工厂类的方法是实例方法，不是静态方法。
    b、实例化时需要factory-bean属性（告诉调用哪个工厂Bean） + factory-method属性（告诉调用工厂Bean的哪个方法）来共同完成
    c、工厂Bean需要交给Spring的IoC容器管理

4.通过FactoryBean接口实例化（测试方法：testInstantiation4()）
    a、上述第3中方法通过factory-bean实例化，factory-bean是我们自定义的，factory-method也是我们自定义的。
    b、而本方法（通过FactoryBean接口实例化），在Spring中，当我们编写的类直接实现了FactoryBean接口后，factory-bean和factory-method都不再需要我们指定了。
        factory-bean会自动指向实现了FactoryBean接口的类，factory-method会自动指向getObject()方法。
    c、简而言之，第4种方法就是第3种方法的简化。
