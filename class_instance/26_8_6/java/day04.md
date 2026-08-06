Exception 与 RuntimeException 有什么区别？
throw 与 throws 的区别？
try-catch-finally 分别负责什么？
什么叫吞异常？
为什么企业项目通常自定义 BusinessException？
为什么 Service 层负责抛业务异常？
统一错误码相比直接返回字符串有什么优势？
SpringBoot 为什么使用全局异常处理，而不是每个 Controller 都写 try-catch？

1. Exception是一个异常父类，RuntimeException是Exceptdion的子类之一

2. throw 是用于方法内部抛出异常 throws 用于方法声明该方法内部可能抛出的异常

3. try负责检测try内部的方法是否有出现异常，内部要放一些可能出现异常的方法 ， catch用于捕获try发出的异常内容 ， finally 是无论是否出现
异常，最终都会输出告诉用户结束捕获异常
4. 如果多个catch相连时，父类异常放在子类异常之前，当子类异常触发时，优先会被父类异常捕获，这样永远不知道是子类的异常
5. 每个企业的异常捕获校验的具体内容会根据业务逻辑去变化
6. Service层是业务逻辑层，这一层统一存放关于业务逻辑的代码，异常的捕获也有约束用户合规使用的作用，所以需要把异常捕获放在service层
7. 统一错误码方便开发人员能够根据错误码找到错误所在
8. 一般的项目中各个模块都有其对应的Controller层，使用全局异常处理可以提高代码复用性
