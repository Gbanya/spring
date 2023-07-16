AOP的优点：
    ·代码复用性增强
    ·代码易维护
    ·使开发者更关注业务逻辑

Spring对AOP的实现包括以下三种方式：
    第一种方式：Spring框架结合AspectJ框架实现的AOP，基于注解方式（重要）
    第二种方式：Spring框架结合AspectJ框架实现的AOP，基于XML方式
    第三种方式：Spring框架自己实现的AOP，基于XML方式
    在实际开发总，都是Spring框架+AspectJ来实现AOP，所以重点学习第一种和第二种。


通知类型：
    ·前置通知：@Before 目标方法执行之前的通知
    ·后置通知：@AfterReturning 目标方法执行之后的通知
    ·环绕通知：@Around 目标方法执行之前添加通知，同时目标方法执行之后添加通知
    ·异常通知：@AfterThrowing 目标方法发生异常之后执行的通知
    ·最终通知：@After 放在finally语句块中的通知


当一个方法对应多个切面，如何保证切面的执行顺序？
    ·在切面上使用@Order注解，值越小越先执行
    ·一定要在增强方法中执行目标方法，这样后面的切面才会执行。

测试方法：
    1.使用XML+注解实现的AOP，测试方法：SpringAopTest.testAround()
    2.基于注解全开发实现的AOP，测试方法：SpringAopTest.testNoXml()

