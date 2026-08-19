1. 为什么增强for中直接删除集合元素可能出问题？
增强for本身底层是一个Iterator在运行，当遇到要删除的元素时，有可能Iterator还在遍历，
但是有可能元素已经被删了，所以就会爆出异常
2. Iterator的hasNext()、next()、remove()分别有什么作用？
hasNext（）用于判断是否还有下一个元素，next（）调用下一个元素，remove移除元素
3. Iterator删除和removeIf()有什么区别？
Iterator的删除可以用于复杂的业务场景来删除元素。
removeif()用于简单的条件筛选来删除元素

4. getOrDefault()解决了什么问题？
   举一个实际业务例子。
解决需要对元素是否存在后决定要不要填写默认值
比如某个品类的商品价格有没有值，如果没有的话就填0

5. computeIfAbsent()是什么意思？
   为什么Map<String, List<User>>分组特别适合使用它？
如果key不存在的话，就根据设定的规则放入一个计算好的value
如果key存在的话就把已有的value直接放进去
   