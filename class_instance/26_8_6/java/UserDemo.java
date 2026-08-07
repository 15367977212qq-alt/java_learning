//public class UserDemo {
//
//    public static void main(String[] args) {
//        UserService service = new UserService();
//
//        User user = null;
//
//        // 场景1：正常创建
//        try {
//            user = service.createUser(1L, "Tom", 20);
//            System.out.println("创建成功：" + user);
//        } catch (BusinessException exception) {
//            printException(exception);
//        }
//
//        // 场景2：用户名为空
//        try {
//            service.createUser(2L, "   ", 18);
//        } catch (BusinessException exception) {
//            printException(exception);
//        }
//
//        // 场景3：年龄为负数
//        try {
//            service.createUser(3L, "Jerry", -1);
//        } catch (BusinessException exception) {
//            printException(exception);
//        }
//
//        // 场景4：正常禁用
//        try {
//            service.disableUser(user);
//            System.out.println("禁用成功：" + user);
//        } catch (BusinessException exception) {
//            printException(exception);
//        }
//
//        // 场景5：重复禁用
//        try {
//            service.disableUser(user);
//        } catch (BusinessException exception) {
//            printException(exception);
//        }
//    }
//
//    private static void printException(BusinessException exception) {
//        System.out.println("错误码：" + exception.getCode());
//        System.out.println("错误信息：" + exception.getMessage());
//    }
//}