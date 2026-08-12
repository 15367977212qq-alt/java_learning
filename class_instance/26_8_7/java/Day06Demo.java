import java.util.*;
import java.util.stream.Collectors;

public class Day06Demo {
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




        List<User> adultsOld = userService.filterUsers(
                    users ,
                user -> user.getAge() != null
                        && user.getAge() >= 18
        );

        List<User> adultsStream = users.stream()
                .filter(
                        user -> user.getAge() != null
                        && user.getAge() >= 18
                ).collect(Collectors.toList());
        /*
            for循环对应users.stream()
            if条件对应.filter()中括号内的内容
            result.add(user)最终被toList()替代
         */

        List<User> activeUsers = userService.filterUsers(
                users,
                user -> "ACTIVE".equals(user.getStatus())
        );

        List<String> usernames =
                users.stream()
                .map(User::getUsername)
                        .collect(Collectors.toList());

        List<Long> userIds =
                users.stream()
                        .map(User::getId)
                .collect(Collectors.toList());

        List<User> sortedUsers = users.stream()
                .sorted(
                        Comparator.comparing(
                                User::getAge
                        )
                ).collect(Collectors.toList());

        List<User> unsortedUsers = users.stream()
                .sorted(
                        Comparator.comparing(
                                User::getAge
                        ).reversed()
                ).collect(Collectors.toList());

        ApiResponse<User> response =
                ApiResponse.success(user1);

        System.out.println(response);

        ApiResponse<List<User>> listResponse =
                ApiResponse.success(adultsOld);

        System.out.println(listResponse);

        System.out.println("旧版成年人：" + adultsOld);
        System.out.println("新版成年人:" + adultsStream);
        System.out.println("用户姓名：" + usernames);
        System.out.println("用户id:" + userIds);
        System.out.println("用户排序显示：" + sortedUsers);
        System.out.println("用户倒序显示："  + unsortedUsers);
        System.out.println("ACTIVE用户：" + activeUsers);

        /*
        业务场景组合
         */
        List<String> ActiveUsernames = activeUsers.stream()
                .map(User::getUsername)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("所有的ACTIVE用户：" + ActiveUsernames);
    }
}
