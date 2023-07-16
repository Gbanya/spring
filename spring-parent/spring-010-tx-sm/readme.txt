一、Spring对事务的支持
    1. Spring实现事务的两种方式：
        · 编程式事务
            · 通过编写代码来实现事务的管理（自己手写aop）
        · 声明式事务
            · 基于注解方式
            · 基于XML配置方式

    2. Spring对事务的管理底层实现方式是基于AOP实现的，所以Spring专门针对事务开发了一套API，
    API的核心接口为PlatFormTransationManager,在Spring6中有两个实现：
        · DataSourceTransationManager：支持JdbcTemplate、mybatis、Hibernate等事务管理
        · JtaTransationManager: 支持分布式事务管理

    3. 事务的七种传播行为
        · REQUIRED：支持当前事务，如果不存在就新建一个（默认）。 【没有就新建，有就加入】
        · SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行。 【有就加入，没有就不管了】
        · MANDATORY：必须运行在一个事务中，如果当前没有事务，就抛出异常。 【有就加入，没有就抛异常】
        · REQUIRES_NEW：开启一个新的事务，如果一个事务已经存在，则将这个存在的事务挂起。 【不管有没有，直接开启一个新事务，开启的新事务和之前的事务不存在嵌套关系，之前存在的事务被挂起】
        · NOT_SUPPORTED：以非事务方法运行，如果有事务存在，挂起当前事务。 【不支持事务，存在就挂起】
        · NEVER：以非事务方法运行，如果有事务存在，抛出异常。 【不支持事务，存在就抛异常】
        · NESTED：如果当前正有一个事务在进行中，则该方法应当运行在一个嵌套式事务中。被嵌套的事务可以独立于外层事务进行提交或回滚。
                    如果外层事务不存在，行为就像REQUIRED一样 【有事务的话就在这个事务里再嵌套一个完全独立的事务，嵌套的事务可以独立的提交和回滚。没有事务就和REQUIRED一样】

        在代码中设置事务的传播行为：
            @Transacational(propagtion = Propagation.REQUIRED)

    4. 事务的隔离级别
        · 读未提交
            这种隔离级别，存在脏读问题。（脏读：事务能读到其他事务未提交的数据，也就是读到了其他事务中缓存的数据）
        · 读已提交
            解决了脏读问题，其他事务提交之后才能读到数据。但该隔离级别存在不可重复度问题
        · 可重复度
            解决了不可重复读，可以达到重复度效果，只要当前事务不结束，读到的数据一直都是一样的。但存在幻读的问题。
        · 序列化
            解决了幻读的问题，事务排队执行，不支持并发。

        在代码中设置事务额隔离级别：
            @Transactional(isolation = Isolation.READ_COMMITED)

    5. 事务超时
        ·@Transactionl(timeout = 10);
            以上代码表示设置事务的超市时间为10秒。表示超过10秒如果该事务中所有的DML（增、删、改、查）语句都没有执行完毕的话，最终结果会选择回滚。
        ·注意：事务的超时时间是指哪段时间？
            在当前事务中，最后一条DML语句执行之前的时间表示当前事务的执行时间。如果最后一条DML语句后面还有很多业务逻辑，这些业务代码的执行时间不被计入超时时间。

    6. 只读事务
        · @Transactional(readOnly = true)
            将当前事务设置为只读事务，在该事务执行过程中只允许select语句执行，delete、insert、update均不可执行。
        · 该特性的作用是：
            启动Spring的优化策略，提高select语句的执行效率。

    7. 设置哪些异常回滚事务
        · @Transactional(rollbackFor = NumberFormatException.class)
            表示只有发生NumberFormatException异常或该异常的子类异常才回滚

    8. 设置那些异常不会滚事务
        · @Transactional(noRollbackFor = NumberFormatException.class)
            表示发生NumberFormatException或该异常的子类异常不会滚，其他异常则回滚。


【spring-010-tx-sm模块将展示Spring6如何集成mybatis】

二、Spring6继承Mybatis3.5
实现步骤：
    第一步：准备数据库
        · 使用idea自带的数据库插件，选择右栏Database
        · 数据库URL:  jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
        · 使用t_ac表（账户表）

    第二步：IDEA中创建一个模块，并引入依赖
        · spring-context
        · spring-jdbc
        · mysql驱动
        · mybatis
        · mybatis-spring （mybatis提供的与spring框架集成的依赖）
        · Druid连接池
        · junit

    第三步： 基于三层架构实现，准备相关包
        · com.yuan.bank.mapper
        · com.yuan.bank.service
        · com.yuan.bank.service.impl
        · com.yuan.bank.pojo

    第四步：编写pojo
        · Account，属性私有化，提供公开的setter、getter和toString

    第五步： 编写mapper接口
        · AccountMapper接口，定义方法

    第六步： 编写mapper配置文件
        · 在配置文件中配置命名空间，以及每一个方法对应的sql

    第七步： 编写Service接口和Service接口的实现类
        · AccountService
        · AccountServiceImpl

    第八步： 编写jdbc-properties配置文件
        · 数据库连接池相关信息

    第九步：编写spring-config配置文件
        · 该文件可以没有，大部分的配置可以转移到spring配置文件中
        · 如果遇到mybatis相关的系统级配置，还是需要这个配置文件

    第十步：编写spring.xml配置文件
        · 组件扫描
        · 引入外部的属性文件
        · 数据源
        · SqlsessionFactory配置
            · 注入mybatis核心配置文件路径
            · 指定包别名
            · 注入数据源
        · Mapper扫描配置器
            · 指定扫描的包 (注：mapper配置文件的路径一定要和dao的路径一样)
        · 事务管理器 DataSourceTransactionManager
            · 注入数据源
        · 启用事务注解
            · 注入事务管理器

    第十一步：编写测试程序，并添加事务，进行测试
