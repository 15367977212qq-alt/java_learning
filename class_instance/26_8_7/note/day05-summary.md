1. Demo、Service、Repository三层分别做什么？
Demo负责运行整个代码层次，Service负责处理业务逻辑，Repository负责数据存取

2. new UserRepository()创建的对象怎样进入Service？
new UserRepository()创建对象->repository引用这个对象->
new UserService(repository)把这个对象的引用传入Service构造器
this.repository = repository 把这个引用保存成成员变量
3. Repository接口存在的意义是什么？
用于定义统一的数据访问抽象，能够让Service层依赖于Repository


4. 一次findUser(2L)的数据调用和返回过程是什么？
demo调用service层的findUser方法->
findUser方法内部转调用Repository层的findById方法
fbi方法落到repository查询数据

5. Optional和BusinessException分别在哪一层出现？为什么？
Optinal是在Servivce的findUser()中产生的，因为Service不希望自己的调用
方直接处理裸null，所以把User/null转换成Optinal<User>,表示这次查询可能
找到用户，也可能没有用户
BusinessException也是在Service层抛出的，

6. 为什么重构后只应该让UserRepository维护用户集合？
要划清各个层之间的职责关系，