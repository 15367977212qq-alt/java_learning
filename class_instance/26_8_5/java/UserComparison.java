public class UserComparison {
    public static void main(String[] args) {
        User2 user1 = new User2(1,"Tom",20,"ACTIVE");
        User2 user2 = new User2(1,"Tom",20,"ACTIVE");
        User2 user3 = user1;

        System.out.println(user1==user2);//返回false，因为u1跟u2的指向地址不同
        System.out.println(user1.equals(user2));//返回false，因为u1与u2的指向地址不同
        System.out.println(user1==user3);//返回true，两个变量指向同一个地址快
        System.out.println(user1.equals(user3));//返回true，因为u1与u3的变量id值都是1
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
