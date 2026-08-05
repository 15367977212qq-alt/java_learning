1.为什么 String 是不可变对象？
2 StringBuilder 为什么更适合频繁拼接？
3 int 与 Integer 的区别是什么？
4 自动拆箱为什么可能导致空指针？
5 == 与 equals() 的区别？
6 为什么重写 equals() 后必须重写 hashCode()？
7 SpringBoot 实体类为什么大量使用 Long、Integer 而不是 long、int？

1：String背后底层逻辑其实是由char[]数组构成的，而且这些char[]都是用
private status final 修饰的 ，也没有可以修改char[]的方法存在

2：如果使用+来频繁拼接，每一次拼接都会抛弃旧的字符串，Stringbuilder是个可变
对象，可预分配缓存，往strngbuilder中添加字符时，不会创建新的临时对象

3:int 是基本类型， Integer 是包装类型，Integer可以视为int的引用类型形态 基本类型的值不能为null
包装类型的值可以为null ， int 的实例的值可以改变 ，Integer是不变类，用private final修饰一旦
创建对象，该对象便不可改变

4:若创建的Integer对象的值为null，当使用自动拆箱将Integer的值赋给int类型的对象时
会发生空指针报错

5== 比较基本类型时 ，比较的是具体的值
    比较引用类型时，判断的是两个变量是否执行同一个对象
equals() 默认跟 == 类似 ， 但是可以重写他 ，所以可以用于比较引用类型的对象内容

6；不知道

7：不知道