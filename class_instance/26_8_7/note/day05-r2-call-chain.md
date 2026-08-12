userService.getRequiredUser(100L);

Day05Demo
↓ 调用了UserService

UserService
↓ 调用了getRequiredUser这个方法

Repository<User, Long>
↓ 实际执行类为UserRepository

UserRepository
↓ 查询传入的100L

List<User>
↓ 没找到后返回什么？
    没找到会返回null

findUser
↓   将null转为Optional.empty
    
Optional.empty()
↓   

orElseThrow
↓ 查询不到 抛出异常

BusinessException


反方向路程为
Jack
↓
UserRepository return Jack
↓
回到 UserService.findUser()
↓
Optional.ofNullable(Jack)
↓
Optional<User>
↓
Service return Optional<User>
↓
Day05Demo
↓
result
List<User> 接受到查询结果为null交由UserRepository返回
然后通过Repostiory返回到UserService,最终在Demo中被捕获到异常，
最终打印出来

