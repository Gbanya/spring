1. OCP
    * 什么是OCP?
        OCP是软件七大开发原则中最基本的一个原则: 开闭原则
        对什么开？对扩展开放
        对什么关？对修改关闭
    * OCP原则是最核心的，最基本的，其他的六个原则都是为这个原则服务的。
    * OCP开闭原则的核心是什么？
        只要你在扩展系统功能的时候，没有修改以前写好的代码，那么这个系统就是符合OCP原则的。
        反之，如果在扩展系统功能的时候，修改了之前的程序，之前所有的程序都需要重新进行测试，这个就是非常麻烦的，应避免。

2. 依赖倒置原则（DIP原则）
    * 什么是依赖导致原则？
        面向接口编程，面向抽象编程。不要面向具体编程。
    * 依赖倒置原则的目的？
        降低程序的耦合度，提高扩展力
    * 什么叫符合依赖倒置？
        上层 不依赖 下层，就是符合的。（上层不要显示创建下层的实现类对象）
    * 什么叫不符合依赖倒置？
        上层 依赖 下层：  只要下层一改动，上层就会收到影响，需要改动代码。

3. 当前设计的程序，既违背OCP又违背DIP，怎么优化？
    可以采用“控制反转”这种编程思想来解决这个问题。

4. 什么是控制反转？
    * 控制反转： IOC（Inversion Of Control）
        控制反转是一种编程思想，或者叫一种新型的设计模式。由于出现比较新，没有被纳入GoF23种设计模式范围内。
    * 反转什么呢？
        反转两件事：
            a、不在程序中采用硬编码的方式来new对象了了。（new对象的权力交出去）
            b、不在程序中采用硬编码的方式来维护对象的关系了。（对象之间关系的维护权也交出去）

5. Spring框架
    * Spring框架实现了控制反转IOC思想
        Spring框架可以帮助你new对象
        Spring框架可以帮你维护对象和对象之间的关系
    * Spring是一个实现了IOC思想的容器。
    * 控制反转的实现方式有多种，其中比较重要的是：依赖注入（Depenency Injection，简称DI）.
    * 控制反转是思想，依赖注入是这种思想的具体实现。
    * 依赖注入DI，又包括常见的两种方式：
        a、set注入（执行set方法给属性赋值）
        b、构造方法注入（执行构造方法给属性赋值）
    * 依赖注入中“依赖”是什么意思？“注入”是什么意思？


        依赖：对象A和对象B之间的关系
        注入：是一种手段，通过这种手段，可以让对象A和对象B产生关系。
        依赖注入：对象A和对象B之间的关系，靠注入的手段来维护。而注入包括：set注入和构造注入。

6. 注意术语：
    OCP: 开闭原则（开发原则）
    DIP: 依赖倒置原则（开发原则）
    IOC: 控制反转（一种思想，一种新型的设计模式）
    DI: 依赖注入（控制反转思想的具体实现方式）
