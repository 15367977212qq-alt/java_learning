1. Java泛型解决了什么问题？
用于解决ArrayList需要根据不同的数据类型创建不同的ArrayList方法

2. T和ID是Java固定的数据类型吗？
不是，T和ID可以是任何你新建的类，但不能是基本类型

3. List<User>为什么比原始List更安全？、
不知道

4. 泛型类和泛型方法有什么区别？
不知道
5. public static <T> ApiResponse<T> success(T data)
   中三个T分别代表什么？
第一个T 代表该方法接收的数据类型是T类型
第二个T 代表这个方法内部的参数是T类型
第三个T 代表传入的参数是T类型

6. Repository<User, Long>中的User和Long分别表示什么？
User 指的是User user = new User(); 中的user实例
Long 是 id

7. Optional解决了什么问题？
解决了在查询数据时提前声明了查询结果可能为空

8. Optional.of()和Optional.ofNullable()有什么区别？
前者不会声明查询结果可能为空，后者提前告诉了调用者返回的结果可能为null

9. 为什么不建议直接使用Optional.get()？
这样就失去了使用Optional的意义

10. orElse()和orElseGet()有什么区别？

11. orElseThrow()适合什么业务场景？

12. 什么是函数式接口？
接口中只有一个抽象方法，可以使用lambda表达式调用接口

13. Lambda表达式和函数式接口有什么关系？
函数式接口可以使用lambda表达式调用


14. Repository层和Service层的职责有什么区别？
Service层是业务逻辑层，用于声明方法的内部逻辑
Repository是数据存储层，用于存放数据

15. 为什么Repository可以返回null，
    而Service需要将其转换成Optional或BusinessException？
不知道