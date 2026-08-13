1. Stream执行模型｜概念题
分析：
List<String> names = users.stream()
.filter(user -> user.getAge() >= 18)
.map(User::getUsername)
.sorted()
.collect(Collectors.toList());

请写出每一步执行后的类型，并分别解释：

stream()
filter()
map()
sorted()
collect()

各自在干什么。
stream（）将users中的数据一个个传入
filter（）是一个过滤门，过滤出符合条件的数据
map是映射器，将元素映射成另一个元素
sorted（）是排序器
collect（）将符合规则的数据收集起来

2. filter() 与 map()｜代码阅读题

判断下面代码最终得到什么：

List<User> users = List.of(
new User(1L, "Tom", 20, "ACTIVE"),
new User(2L, "Jack", 16, "ACTIVE"),
new User(3L, "Alice", 25, "DISABLED")
);

List<String> result = users.stream()
.filter(user -> "ACTIVE".equals(user.getStatus()))
.filter(user -> user.getAge() >= 18)
.map(User::getUsername)
.collect(Collectors.toList());

回答：

① result里有什么？
② 第一个filter删除了谁？
③ 第二个filter又删除了谁？
④ map执行前是什么类型？
⑤ map执行后是什么类型？

result里有一个user
删除了Alice
删除了Jack
map执行前是stream<String> 执行后是stream<name>

3. 独立编码｜核心题
现在有：
List<User> users;
要求：
找出所有 ACTIVE 且年龄 >=18 的用户，只返回用户名，并按照用户名倒序排列。
最终类型必须是：
List<String>

请写出完整 Stream 代码。
List<String> usernameof3 = users.stream()
                    .filter(user -> "ACTIVE".equals(user.getStatus())
                                    && user.getAge() >= 18)
                    .map(User::getUsername)
                    .sorted(Comparator.reverseOrder())
                    .toList();


4. 请结合下面传统代码解释：

List<User> result = new ArrayList<>();

for (User user : users) {
if (user.getAge() >= 18) {
result.add(user);
}
}

分别说明传统写法中的：

for                 整个 Stream 流水线共同完成传统 for + if + add 的工作。
if                 对应filter筛选
result.add()    对应.collect
最终result  对应着toList

与Stream处理思想之间是什么关系。

5. 企业场景｜选择题 + 原因

现在是一个 SpringBoot 用户系统。

Service需要完成两个需求。

需求A：

查询数据库得到100个User，需要筛选ACTIVE用户 → 转成UserVO → 按创建时间排序 → 返回Controller。

需求B：

给100个用户逐个发送邮件；如果某个用户发送失败，需要记录失败原因、重试，并更新数据库中的发送状态。

你认为：

A：Stream / 普通for循环？

B：Stream / 普通for循环？

分别说明原因。

这里考察的不是“Stream代码更短”，而是你是否开始理解：

数据转换型处理
vs
具有复杂副作用和控制流程的处理

之间的区别。

A选择Stream 因为返回类型需要转成UserVO 并且还需要排序
B选择for循环 因为没个用户在判断失败时都需要去记录和更新