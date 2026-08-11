1. Demo、Service、Repository三层分别做什么？
Demo负责运行整个代码层次，Service负责处理业务逻辑，Repository负责数据存取

2. new UserRepository()创建的对象怎样进入Service？
不知道
3. Repository接口存在的意义是什么？
用于定义统一的数据访问抽象，能够让Service层依赖于Repository


4. 一次findUser(2L)的数据调用和返回过程是什么？
demo调用service层的findUser方法->
findUser方法内部转调用Repository层的findById方法
fbi方法落到repository查询数据

5. Optional和BusinessException分别在哪一层出现？为什么？
不知道
6. 为什么重构后只应该让UserRepository维护用户集合？
要划清各个层之间的职责关系，