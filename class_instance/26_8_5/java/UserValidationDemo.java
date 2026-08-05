public class UserValidationDemo {

    public static void main(String[] args) {
        UserValidationService service = new UserValidationService();

        System.out.println(service.isAdult(20));      // true
        System.out.println(service.isAdult(16));      // false

        System.out.println(service.isValidUsername("Tom")); // true
        System.out.println(service.isValidUsername("   ")); // false

        try {
            service.isAdult(null);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}