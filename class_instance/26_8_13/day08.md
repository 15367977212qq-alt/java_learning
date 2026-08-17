List / Set / Map 分别适合什么业务？
为什么角色适合 Set<String>？
Map<Long, User> 两个泛型分别代表什么？
为什么频繁按 userId 查询适合 Map？
相同 Key 重复 put() 会发生什么？

1. list有顺序，允许重复，时候存不在头尾新增的业务，如任务队列，信息流，set适合唯一性
校验以及去重，用户权限标签分类，map用于存储
2. set集合不允许存储相同的数据，正适应了角色这个业务场景
3.  Long代表key ， User代表Value
   4.  如果频繁按id查User,Map的value-key的数据结构适合查询，可以直接根据key查询到对应的value
5. 新key对应的value会覆盖旧的value