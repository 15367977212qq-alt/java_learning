1. Stream API主要解决什么问题？
Stream API 主要是用于对集合数据进行声明式的筛选，转换，排序，聚合等流水线处理
2. stream()之后得到的是List还是Stream？
   List<User>
   ↓ stream()
   Stream<User>
   ↓ filter()
   Stream<User>
   ↓ map(User::getUsername)
   Stream<String>
   ↓ sorted()
   Stream<String>
   ↓ toList()
   List<String>

3. filter()接收的Lambda最终要返回什么类型？
filter()中的Lambda最终必须返回boolean类型


4. filter()和map()最大的区别是什么？
filter是在原数据类型中进行筛选
map()是对每个元素执行一个映射操作，并用映射结果替换为原来的元素 

5. 为什么map(User -> username)后，
   Stream<User>会变成Stream<String>？
User -> username 中的映射函数返回的是String类型
因此输出流会变成Stream<String>
6. toList()起什么作用？
将Stream()流水线上符合规则的数据打包到新的List中

7. users.stream().filter(...).toList()
   会不会修改原来的users？
不会修改原来的users，只是对原来的users进行规则筛选并重新打包成新的List