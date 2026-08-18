import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        Map<User,String> map = new HashMap<>();
        map.put(u1,"First");
        map.put(u2,"Second");
        System.out.println(map.size());
        System.out.println(map.get(u1));
    }
}
