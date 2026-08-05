import model.User;
import service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        UserService userService = new UserService();
        User user = userService.createUser(100001L, "小明",10,"ACTIVE");
        System.out.println(user);
        user.setStatus("DISABLED");
        System.out.println(user);
        userService.updateUser(user,"ACTIVE");
        System.out.println(user);

    }
}
