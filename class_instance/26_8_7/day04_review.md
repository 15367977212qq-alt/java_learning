1. throw和throws有什么区别？
2. Service负责抛异常还是捕获异常？
3. 什么叫吞异常？
4. finally主要用于什么？
5. BusinessException为什么需要code？


throw 用于抛出异常 throws用于声明方法内可能抛出的异常

2Service 负责捕获异常

3. catch内部什么都不做，或者只打印了很简单的信息

4. finally用于释放资源，无论有没有捕获到异常最终都会释放

5. 规范异常情况，方便不同成员之间查看异常出在哪
