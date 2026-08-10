import java.util.ArrayList;
import java.util.Arrays;
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

        List<User> users = userService.findAllUser();
        //test4
        Optional<User> result = userService.findUser(1L);
        //为什么这里可以使用lambda格式
        result.ifPresent(
                user -> System.out.println(user)
        );

        //test5
        Optional<User> result2 = userService.findUser(30L);
        System.out.println(result2.isPresent());

        //test6
        try{
            userService.getRequiredUser(100L);
        }catch(BusinessException e){
            System.out.println(e.getCode());
            System.out.println(e.getMessage());
        }

        List<User> adults = userService.filterUsers(
                users ,
                user -> user.getAge() != null
                    && user.getAge() >= 18
        );

        List<User> activeUsers = userService.filterUsers(
                users,
                user -> "ACTIVE".equals(user.getStatus())
        );

        List<User> nameUsers = userService.filterUsers(
                users,
                user -> user.getUsername() != null
                        && user.getUsername()
                        .toLowerCase()
                        .contains("a")
        );

        ApiResponse<User> response =
                ApiResponse.success(user1);

        System.out.println(response);

        ApiResponse<List<User>> listResponse =
                ApiResponse.success(adults);

        System.out.println(listResponse);

        System.out.println("成年人：" + adults);
        System.out.println("ACTIVE用户：" + activeUsers);
        System.out.println("名字包含a：" + nameUsers);
    }
}
