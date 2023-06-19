Bean的声明周期
1、什么是Bean的生命周期
    ·Spring其实就是一个管理Bean对象的工厂。它负责对象的创建，以及销毁等。
    ·所谓的生命周期就是：对象从创建开始到最终销毁的整个过程。
    ·什么时候创建Bean？
    ·创建Bean对象的前后会调用什么方法？
    ·Bean对象什么时候销毁？
    ·Bean对象的销毁前后会调用什么方法？

2、为什么需要知道Bean的生命周期
    ·其实生命周期的本质就是：在哪个时间节点上调用了哪个类的哪个方法。
    ·我们需要充分了解在这个生命线上，都有哪些特殊的时间节点。
    ·我们只有知道了特殊的时间节点在哪，我们才可以确定代码写到哪。
    ·我们可能需要在某个特殊的时间点上执行一段特殊的代码，这段代码就可以放到这个节点上。当生命先走到这里的时候，自然会被调用。

3、Bean的生命周期之5步
    Bean的生命周期可以粗略的划分为五大步：
    第一步：实例化Bean
    第二步：Bean属性的赋值
    第三步：初始化Bean
    第四步：使用Bean
    第五步：销毁Bean

4、Bean的生命周期之7步
    第一步：实例化Bean
    第二步：Bean属性的赋值
    第三步：执行“Bean后处理器”的before方法。（新增）
    第四步：初始化Bean
    第五步：执行“Bean后处理器”的after方法。（新增）
    第六步：使用Bean
    第七步：销毁Bean

5、Bean的生命周期之10步
    第一步：实例化Bean
    第二步：Bean属性的赋值
    第三步：检查Bean是否实现了Aware的相关接口，并设置相关依赖（新增）
            第三步的作用：
                检查Bean是否实现了Aware的相关接口，如果实现了接口则调用这些接口中的方法。然后调用这些方法的目的是为了给你传递一些数据，让你更加方便使用。
    第四步：执行“Bean后处理器”的before方法。
    第五步：检查Bean是否实现了InitializingBean接口，并调用接口方法（新增）
            第五步的作用：
                检查Bean是否实现了InitializingBean接口，如果实现了，则调用接口中的方法。
    第六步：初始化Bean
    第七步：执行“Bean后处理器”的after方法。
    第八步：使用Bean
    第九步：检查Bean是否实现了DisposableBean接口，并调用接口方法（新增）
            第九步的作用：
                检查Bean是否实现了DisposableBean接口，如果实现了，则调用接口中的方法。
    第十步：销毁Bean

    a、添加的这三个点位的特点：都是在检查你这个Bean是否实现了某些特定的接口，如果实现了这些接口，则Spring容器会调用这个接口中的方法。
    b、Aware相关的接口包括：BeanNameAware、BeanClassLoaderAware、BeanFactoryAware
        ·当Bean实现了BeanNameAware，Spring会将Bean的名字传递给Bean。
        ·当Bean实现了BeanClassLoaderAware，Spring会将加载该Bean的类加载器传递给Bean。
        ·当Bean实现了BeanFactoryAware，Spring会将Bean工厂对象传递给Bean。

6、Bean的作用域不同，管理方式也不同
    Spring根据Bean的作用域来选择管理模式：
        ·对于singleton作用域的Bean，Spring能够精确地知道该Bean何时被创建，何时初始化完成，以及何时被销毁。
        ·而对于prototype作用域的Bean，Spring只负责创建，当容器创建了Bean的实例，并且Bean的实例交给客户端代码管理后，Spring容器将不再跟踪其生命周期。

7、自己new的对象纳入Spring容器管理
    ·使用DefaultListableBeanFactory工厂
    ·测试方法 testRegisterBean()