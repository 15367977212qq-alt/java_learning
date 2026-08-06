//public class UserComparison {
//
//    public static void main(String[] args) {
//        User2 user1 = new User2(1L, "Tom", 20, "ACTIVE");
//        User2 user2 = new User2(1L, "Tom", 20, "ACTIVE");
//        User2 user3 = user1;
//
//        // false：user1和user2是两个不同对象
//        System.out.println(user1 == user2);
//
//        // true：重写equals后，两个用户的id相同
//        System.out.println(user1.equals(user2));
//
//        // true：user1和user3指向同一个对象
//        System.out.println(user1 == user3);
//
//        // true：同一个对象当然相等
//        System.out.println(user1.equals(user3));
//
//        // 相等对象必须具有相同的hashCode
//        System.out.println(user1.hashCode());
//        System.out.println(user2.hashCode());
//    }
//}