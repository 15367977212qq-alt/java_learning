1. Stream API主要解决什么问题？

2. stream()之后得到的是List还是Stream？
得到的是List
3. filter()接收的Lambda最终要返回什么类型？
不知道
4. filter()和map()最大的区别是什么？
filter是在原数据类型中进行筛选
map是将一种数据类型转成另一种数据类型

5. 为什么map(User -> username)后，
   Stream<User>会变成Stream<String>？
不知道怎么解释

6. toList()起什么作用？
将Stream()流水线上符合规则的数据打包到新的List中

7. users.stream().filter(...).toList()
   会不会修改原来的users？
不会修改原来的users，只是对原来的users进行规则筛选并重新打包成新的List