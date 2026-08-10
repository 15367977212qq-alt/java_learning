1. Java泛型解决了什么问题？
   泛型让类、接口、方法能够复用不同类型，
   同时在编译期进行类型检查，
   减少强制类型转换和运行时类型错误。

2. T和ID是Java固定的数据类型吗？
   T和ID是泛型类型参数，不是Java固定类型。

使用时可以替换为任何合适的引用类型，例如：
User、String、Long、Integer、List<User>等。

不能直接使用int、long等基本类型，
需要使用Integer、Long等包装类型。

3. List<User>为什么比原始List更安全？、
**List<User>在编译阶段就限制元素必须是User类型，
   错误类型无法随意加入。

读取时直接得到User，不需要从Object强制转换，
因此减少ClassCastException风险。**

4. 泛型类和泛型方法有什么区别？
   泛型类：

public class ApiResponse<T>

T对整个类的实例方法和字段有效。

泛型方法：

public static <T> ApiResponse<T> success(T data)

这个 T 是这个方法自己声明的，只在方法范围内使用。
5. public static <T> ApiResponse<T> success(T data)
   中三个T分别代表什么？
第一个T 代表该方法接收的数据类型是T类型
第二个T 代表这个方法内部的参数是T类型
第三个T 方法参数data的类型是T

6. Repository<User, Long>中的User和Long分别表示什么？
User 指的是User user = new User(); 中的User类型的数据
Long 是 id

7. Optional解决了什么问题？
解决了在查询数据时提前声明了查询结果可能为空

8. Optional.of()和Optional.ofNullable()有什么区别？
   正确区别：

Optional.of(user)
要求：
user不能为null
否则：
NullPointerException
而：
Optional.ofNullable(user)
允许：
user == null
null会被转换成：
Optional.empty()
9. 为什么不建议直接使用Optional.get()？
这样就失去了使用Optional的意义

10. orElse()和orElseGet()有什么区别？
    optional.orElse(createUser())

createUser() 会先执行。

而：

optional.orElseGet(() -> createUser())

只有Optional为空时才执行。

所以默认对象创建成本较大时，orElseGet()更合适。
11. orElseThrow()适合什么业务场景？
    修改用户
    删除用户
    查询用户详情
这些业务要求目标用户必须存在。
所以：
findUser(id)
.orElseThrow(
() -> new BusinessException(
"USER_NOT_FOUND",
"用户不存在"
)
);
12. 什么是函数式接口？
接口中只有一个抽象方法，可以使用lambda表达式调用接口

13. Lambda表达式和函数式接口有什么关系？
    函数式接口只有一个抽象方法，Lambda表达式可以用来提供这个抽象方法的具体实现。


14. Repository层和Service层的职责有什么区别？
Repository是数据访问层/数据访问抽象，
负责保存、查询、修改、删除等数据操作。
真正存储数据的是：
今天 → List<User>
以后 → MySQL数据库
即：
Repository ≠ 数据库
Repository
↓ 访问
数据库

15. 为什么Repository可以返回null，
    Repository可以返回null
    Service再转换Optional/BusinessException

因为职责不同：

Repository：
“数据库有没有查询到记录？”

Service：
“业务上这个结果意味着什么？”

例如数据库没找到User：

Repository：

return null;

Service场景A：

“用户可能不存在”

return Optional.empty();

Service场景B：

“用户必须存在”

throw new BusinessException(
"USER_NOT_FOUND",
"用户不存在"
);

这就是数据事实和业务语义的区别。