DateTimeFormatter formatter =
DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

String createdAt =
user.getCreatedAt().format(formatter);
① user.getCreatedAt() 返回什么Java类型？
② format(formatter) 返回什么Java类型？
③ MM 和 mm 分别表示什么？
④ 为什么User Entity里可以使用LocalDateTime，
而UserVO里可以选择String？
1. 返回localDatetime类型的数据
2. 返回自定义格式的时间类型的String类型数据
3. MM代表月份 mm代表分钟
4. 类内部的初始定义了数据类型

class User {
Long id;
String username;
String password;
String status;
LocalDateTime createdAt;
}

① 为什么不建议Controller直接返回User？
② 应该设计什么对象返回？
③ password应该如何处理？
④ Entity → VO转换应该主要放在哪一层？为什么？
1. Controller直接返回User会导致安全数据暴露给前端
2. 设计VO对象返回
3. password不返回，即VO中没有这个值
4. Service层，不知道为什么

List<User> users;
筛选所有 ACTIVE 用户 → 转换成 UserVO → createdAt 
格式化成 yyyy-MM-dd HH:mm:ss → 按 username 倒序 → 返回 List<UserVO>。
UserService userservice = new UserService();
List<UserVO> uvo = users.stream()
                    .filter(user -> "ACTIVE".equals(user.getstatus())
                    .map(user -> new UserVO(user.getid(),user.getUsername(),user.getCreatatAt().format(formatter))
                    .sorted(Comparator.comparing(UserVO::getUsername()))
                    .toList()

List<User>
↓Stream()
Stream<User>
↓ filter
Stream<User>
↓ map
Stream<UserVO>
↓ sorted
Stream<UserVO>
↓ toList
List<UserVO>
-- --
下面代码存在问题：

public User(
    Long id,
    String username,
    LocalDateTime createdAt
) {
    this.id = id;
    this.username = username;
    this.createdAt = LocalDateTime.now();
}

业务代码：

LocalDateTime registerTime =
    LocalDateTime.of(2026, 8, 1, 10, 30);

User user =
    new User(1L, "Tom", registerTime);
① 最终user中的createdAt是什么时间？ 允许时的时间
② 为什么这是Bug？     User的构造方法中 this.createdAt =LocalDateTime , 当新建时还是重新获取了当前时间，而没有使用入参
③ 应该如何修改？       this.createdAt = createdAt
④ 什么情况下构造器内部使用LocalDateTime.now()反而是合理的？ 涉及修改的操作、

Day06 间隔复习

不要参考昨天代码。

要求：

从 List<User> 中找出年龄 ≥18 且状态为 ACTIVE 的用户，只获取 username，
并按照用户名倒序返回 List<String>。

List<String> username = users.stream()
                .filter(user -> "ACTIVE".equals(user.getStatus()) && user.getAge() >= 18)
                .map(User::getUserName)
                .sorted(Comparator.reservedOrder())
                .toList()