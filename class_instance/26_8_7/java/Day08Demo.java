import java.util.*;

public class Day08Demo {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User u1 = new User(1L,"Tommy",28,"ACTIVE");
        User u2 = new User(2L,"Alex",18,"ACTIVE");
        User u3 = new User(3L,"Test",16,"ACTIVE");

        users.add(u1);
        users.add(u2);
        System.out.println(users.get(1));
        users.remove(u1);
        System.out.println(users.contains(u2));
        System.out.println(users.contains(u1));

        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        roles.add("USER");
        roles.add("EDITOR");
        roles.add("ADMIN");
        roles.add("USER");
        /*
        Set类型的集合内部元素不可重复，所以只有三个元素
         */
        Map<Long,User> userMap = new HashMap<>();
        userMap.put(1L,u1);
        userMap.put(2L,u2);
        userMap.put(2l,u3);
        System.out.println(userMap.get(2L));
        userMap.containsKey(3L);
        userMap.remove(1L);
        userMap.putAll(userMap);



        }

    }


