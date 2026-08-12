1. Repository<User, Long> repository = new UserRepository();
   创建了几个对象？
创建了一个UserRepository对象

2. repository变量本身是不是UserRepository对象？
不是，repository只是引用了UserRepository对象

3. this.repository = repository;
   左右两个repository分别是什么？
左边的repository是UserService内部的，右边的是传入的repositroy
4. findUser(100L)最终返回null还是Optional.empty()？
   Optional.empty()
5. getRequiredUser(100L)为什么抛BusinessException？
   getRequiredUser不允许查询不到用户