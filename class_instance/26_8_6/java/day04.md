Exception 与 RuntimeException 有什么区别？
throw 与 throws 的区别？
try-catch-finally 分别负责什么？
什么叫吞异常？
为什么企业项目通常自定义 BusinessException？
为什么 Service 层负责抛业务异常？
统一错误码相比直接返回字符串有什么优势？
SpringBoot 为什么使用全局异常处理，而不是每个 Controller 都写 try-catch？

1. Exception 是异常体系中的父类。
   RuntimeException 是其子类，属于非受检异常。
   RuntimeException 编译器通常不强制捕获或声明。
   IOException 等受检异常必须使用 try-catch 或 throws 处理。

2. throw 是用于方法内部抛出异常 throws 用于方法声明该方法内部可能抛出的异常

3. try：执行可能发生异常的代码。
   catch：捕获并处理匹配的异常。
   finally：通常用于释放资源，无论是否发生异常一般都会执行。

finally 不会自动输出任何内容。
4. try {
   service.createUser(...);
   } catch (BusinessException exception) {
   // 什么也不做
   }

危害包括：

错误被隐藏
日志中没有记录
调用方误以为操作成功
问题难以定位
5. 每个企业的异常捕获校验的具体内容会根据业务逻辑去变化
   不只是因为“每个企业业务不同”，还因为需要：

明确区分业务错误与系统错误
携带稳定的错误码
交给全局异常处理器统一处理
为前端、日志和监控提供一致信息
6. Service层是业务逻辑层，这一层统一存放关于业务逻辑的代码，异常的捕获也有约束用户合规使用的作用，所以需要把异常捕获放在service层
7. 统一错误码方便开发人员能够根据错误码找到错误所在
8. 一般的项目中各个模块都有其对应的Controller层，使用全局异常处理可以提高代码复用性
