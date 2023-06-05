依赖注入
    set注入用的比构造注入更多些

1. set注入(必须要有set方法)
    注入的时机是在对象实例化后
    a. 注入外部bean (测试方法 testSetDIOutAndInner())
        外部bean: bean定义在外面,在property标签中使用ref属性继续宁注入.通常这种方法是常用
    b.注入内部bean (测试方法 testSetDIOutAndInner())
        内部bean: 在bean标签中嵌套bean标签
    c.注入简单类型 (测试方法 tsetSetDISimp())
        注入属性的类型是简单类型,例如: String int long float Enum Number CharSequence Date...
        return Void.class != type
        && Void.TYPE != type &&
        (ClassUtils.isPrimitiveOrWrapper(type)  ||
        Enum.class.isAssignableFrom(type) ||
         CharSequence.class.isAssignableFrom(type) ||
          Number.class.isAssignableFrom(type) ||
          Date.class.isAssignableFrom(type) ||           java.util.Date是简单类型，但我们一般不用value，而是使用ref给Date类型赋值
          Temporal.class.isAssignableFrom(type) ||       Temporal是java8提供的时间和时区类型
          URI.class == type ||
          URL.class == type ||
          Locale.class == type ||                         Locale是语言类，也是简单类型
          Class.class == type);
            }
    d.级联属性赋值（了解  测试方法testSetDICascade() ）
        要使用级联给某个属性赋值，一定要注意该属性一定要提供get方法。
    e.注入数组 (测试方法 testSetDIArray())
    f.注入集合(测试方法 testSetDICollection())
        List Set Map Properties
    g.注入null和空字符串
       注入null：属性的默认值就是null，所以不给属性赋值即可。
       注入空字符串： value=""
    h.注入的值中含有特殊符号 (测试方法 testSetDISpecial())
        xml中有5个特殊字符，分别是 < > ' 、 &
        解决方法：
            a、特殊符号使用对应的转义字符代替
            b、将含有特殊符号的字符串放到 <![CDATA[字符串]]> 当中。因为<![CDATA[]]>区中的数据不会被xml文件解析器解析。

2. 构造注入(使用构造方法来给属性赋值)
    注入的时机是在对对象实例化过程中

3. p命名空间注入 (测试方法 testSetDIP())
    作用：简化set配置
    使用p命名空间注入的前提条件：
        a、xml头部信息添加p命名空间配置信息：xmlns:p="http://www.springframework.org/schema/p"
        b、p命名空间注入是基于setter方法的，所以需要对应的属性提供setter方法。

4. c命名空间注入 (测试方法 testSetDIC())
    作用：简化构造注入配置
    使用c命名空间注入的前提条件：
        a、xml头部信息添加p命名空间配置信息：xmlns:c="http://www.springframework.org/schema/c"
        b、c命名空间注入是基于构造方法的，所以需要对应的属性提供构造方法。

5. util命名空间 (测试方法 testSetDIUtil())
    作用：util命名空间可以让配置复用
    使用util命名空间注入的前提条件：
        xml头部信息添加util命名空间配置信息：
            xmlns:util="http://www.springframework.org/schema/util"
            xsi:schemaLocation="http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd"

6. 基于XML的自动装装配


