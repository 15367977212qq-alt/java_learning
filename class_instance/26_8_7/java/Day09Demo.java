import java.util.HashSet;
import java.util.Set;

public class Day09Demo {
    public static void main(String[] args) {
        User u1 = new User(1L,"Tom",20,"ACTIVE");
        User u2 = new User(1L,"Tom",20,"ACTIVE");
        System.out.println(u1.equals(u2));
        System.out.println(u1 == u2);
        Set<User> users = new HashSet<>();
        users.add(u1);
        users.add(u2);
    }
}
