public class UserDemo {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.createUser(1L,
                "Tom",
                20);

        userService.createUser(
                2L,
                "",
                20);
        userService.createUser(
                3L,
                "Jerry",
                -1);

    }
}
