import java.util.List;
import java.util.Optional;

public class Day05Demo {
    public static void main(String[] args) {
        User user1 = new User(1L,"Tom",20,"ACTIVE");
        User user2 = new User(2L,"Jack",16,"ACTIVE");
        User user3 = new User(3L,"Alice",25,"DISABLED");

        Repository<User,Long> repository = new UserRepository();
        UserService userService = new UserService(repository);
        repository.save(user1);
        repository.save(user2);
        repository.save(user3);

        //test4
        Optional<User> result = userService.findUser(1L);
        //为什么这里可以使用lambda格式
        result.ifPresent(
                user -> System.out.println(user)
        );

        //test5
        Optional<User> result2 = userService.findUser(4L);
        System.out.println(result2.isPresent());

        //test6
        try{
            userService.findUser(100L);
        }catch(BusinessException e){
            System.out.println(e.getCode());
            System.out.println(e.getMessage());
        }

        List<User> adults = userService.filterUsers(
                (List<User>) repository,
                user -> user.getAge() != null
                    && user.getAge() >= 18
        );


    }
}
