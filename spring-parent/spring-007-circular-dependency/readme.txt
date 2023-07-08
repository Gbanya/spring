1、什么是Bean的循环依赖？
    A对象中有B对象属性，B对象中有A对象属性，这就是循环依赖

2、Spring解决循环依赖的机理
    Spring为什么可以解决set + singleton模式下循环依赖？
    根本的原因在于：这种方式可以做到将“实例化Bean” 和 “给Bean属性赋值”，这两个动作分开去完成。
    ·实例化Bean的时候：调用无参构造方法来完成。【此时可以先不给属性赋值，可以提前将该Bean对象“曝光”给外界】。
    ·给Bean属性赋值的时候：调用setter方法来完成。
    上面两个步骤是完全可以分离开去完成的，并且这两个步骤不要求在同一个时间点上完成。
    也就是说，Bean都是单例的，我们可以先把所有的单例Bean实例化出来，放到一个集合当中（我们可以称之为缓存），所有的单例Bean
    全部实例化完成之后，以后我们再慢慢的调用setter方法给属性赋值，这样就解决了循环依赖问题。

3、singleton + setter模式下，为什么循环依赖不会出现问题，Spring底层代码是如何实现的？（重要，面试）
    ·首先Bean的生命周期可以参考Spring的源码：AbstractAutowireCapableBeanFactory类的doCreateBean()方法
    ·doCreateBean()方法会用到DefaultSingletonBeanRegistry类中的三个非常重要的缓存：
        private final Map<String, Object> singletonObjects                 一级缓存
        private final Map<String, Object> earlySingletonObjects            二级缓存
        private final Map<String, ObjectFactory<?>> singletonFactories     三级缓存

        这三个缓存都是Map集合。Map集合的key存储的都是bean的name（bean id）
        一级缓存存储的是：单例Bean对象。完整的单例Bean对象，也就是说这个缓存中的Bean对象的属性都已经赋值了。是一个完整的Bean对象。
        二级缓存存储的是：早期的单例Bean对象。这个缓存中的单例Bean对象的属性没有赋值。知识一个早期的实例对象。
        三级缓存存储的是：大力工厂对象。里面存储了大量的“工厂对象”，每一个单例Bean对象都会对应一个简单工厂实例。（也就是说这个集合中存储的是，创建该单例对象时对应的那个单例工厂对象）