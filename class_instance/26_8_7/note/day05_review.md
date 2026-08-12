1. UserService为什么需要Repository？
UserService 仅负责业务逻辑的判断，实际的数据存取需要Mapper层去实现，所以需要分出一个Repository层

2. Repository和UserRepository是不是同一个东西？
   分别是什么？
不是一个东西
Repository是声明接口有哪些功能，UserRepository是Repository的实现类，负责数据存取的真实操作

3. Repository<User, Long>中的User和Long是什么？
User,Long是两类数据类型
4. findUser(100L)查不到时应该得到什么？
找不到用户时会返回null
5. getRequiredUser(100L)查不到时为什么不能同样处理？
因为getRequiredUser的方法声明类型是User,不能以空值返回

new UserRepository()执行了几次？
仅执行了一次
创建了几个UserRepository对象？
一个
为什么Service能够调用Demo创建的Repository？