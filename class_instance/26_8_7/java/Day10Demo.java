import java.util.*;

public class Day10Demo {
    public static void main(String[] args) {
        User u1 = new User(1l,"Tommy",22,"ACTIVE");
        User u2 = new User(2l,"Jerry",33,"ACTIVE");
        User u3 = new User(3l,"Lucy",44,"INACTIVE");
        User u4 = new User(4l,"Jack",15,"ACTIVE");
        User u5 = new User(5l,"Jerry",17,"INACTIVE");
        User u6 = new User(6l,"Jerry",18,"ACTIVE");

        List<User> users = new ArrayList<>();
        users.add(u1);users.add(u2);users.add(u3);users.add(u4);users.add(u5);
        users.add(u6);

        Iterator<User> it = users.iterator();
        while( it.hasNext()) {
            User u = it.next();
            if(u.getAge() < 18){
                it.remove();
                continue;
            }
            System.out.println(u);
        }
        System.out.println("------------------- --------------------");
        users.removeIf(u -> u.getAge() < 18);
        users.forEach(System.out::println);
        System.out.println(UserService.countByStatus(users));
        System.out.println("------------------- --------------------");
        System.out.println(UserService.groupByStatus(users));


    }
}
