//import java.util.Objects;
//
//public class User2 {
//
//    private Long id;
//    private String username;
//    private Integer age;
//    private String status;
//
//    public User2(Long id, String username, Integer age, String status) {
//        this.id = id;
//        this.username = username;
//        this.age = age;
//        this.status = status;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
////    @Override
////    public boolean equals(Object obj) {
////        // 两个引用指向同一个对象
////        if (this == obj) {
////            return true;
////        }
////
////        // obj为null，或者类型不同
////        if (obj == null || getClass() != obj.getClass()) {
////            return false;
////        }
////
////        User2 other = (User2) obj;
////
////        // 本次业务规则：id相同即认为是同一个用户
////        return Objects.equals(id, other.id);
////    }
////
////    @Override
////    public int hashCode() {
////        return Objects.hash(id);
////    }
//}