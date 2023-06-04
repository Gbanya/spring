依赖注入
    set注入用的比构造注入更多些

1. set注入(必须要有set方法)
    注入的时机是在对象实例化后
    a. 注入外部bean:
        外部bean: bean定义在外面,在property标签中使用ref属性继续宁注入.通常这种方法是常用
    b.注入内部bean
        内部bean: 在bean标签中嵌套bean标签
    c.注入简单类型
        注入属性的类型是简单类型,例如: String int long float...

2. 构造注入(使用构造方法来给属性赋值)
    注入的时机是在对对象实例化过程中