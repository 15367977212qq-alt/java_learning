== 和 equals() 判断对象时有什么区别？
HashSet 为什么需要 hashCode() 和 equals()？
为什么 equals() 相等的对象必须具有相同 hashCode()？
如果业务规定“id相同就是同一个User”，equals() 应主要比较什么？
User 作为 HashMap 的 Key 时，为什么也必须注意 equals/hashCode？

1. == 判断基本类型时，比较的是值，比较对象时，比较的是两者是不是同一个对象
equals()默认状态下比较的是引用地址，重写后可以比较具体的值
2. hashset 需要实现查重功能，所以就必须实现新插入元素与已有元素的比较
hashcode用于返回插入数据的索引值，equals用于判断两个元素是否相同
3. equals() 相等的对象必须有相同 hashCode()，是为了保证它们在 HashMap、HashSet
   等哈希结构里会被放到/找到同一个位置。
4. 主要比较两个User类的id数值是否相同
5. User作为key，hashmap需要靠hashcode找到存储这个User的位置，然后靠equals来判断
是不是同一个key