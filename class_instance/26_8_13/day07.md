LocalDate 与 LocalDateTime 有什么区别？
yyyy-MM-dd HH:mm:ss 中 MM 和 mm 分别代表什么？
LocalDateTime.format() 后返回什么类型？
Entity、DTO、VO分别解决什么问题？
为什么不能把包含 password 的 User Entity 直接返回前端？
Stream<User> 如何通过 map() 变成 Stream<UserVO>？
为什么 getActiveUserVOs() 的转换逻辑更适合放Service，而不是Repository？

1. localdate 仅有日期 ， localdatetime 输出的是日期和时间
2. MM是月份 mm是分钟
3. 返回String类型
4. Entity对应持久化的数据结构，Dto用于不同层之间传输所需的数据，VO用于接口返回数据给前端
5. 如果直接把全量字段返回给前端会导致数据泄露
6. 通过user -> new UserVo(get...)通过构造方法将user的id，name，createdat传给uservo
7. getActiveUserVOs() 这个方法并不设计数据库的存取，仅仅是限制了返回时的字段，更适合放在Service层