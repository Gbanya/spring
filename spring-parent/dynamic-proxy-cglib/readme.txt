
CGLIB动态代理：
    · 创建字节码增强器对象： Enhancer enhancer = new Enhancer();
    · 设置回调（负责编写增强部分代码）：
            第一步：自己编写方法拦截器MethodInterceptor接口的实现类，该类中编写增强类以及调用目标类方法
            第二步：字节码增强器设置回调：enhancer.setCallback(new TimerMethodInterceptor());
    · 字节码增强器创建代理对象：Uservice userviceProxy = (Uservice)enhancer.create();

测试方法：Client类