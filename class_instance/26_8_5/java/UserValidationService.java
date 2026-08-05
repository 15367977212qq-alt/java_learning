public class UserValidationService {

    public boolean isAdult(Integer age) {
        if (age == null) {
            throw new IllegalArgumentException("年龄不能为空");
        }

        if (age < 0) {
            throw new IllegalArgumentException("年龄不能小于0");
        }

        return age >= 18;
    }

    public boolean isValidUsername(String username) {
        return username != null
                && !username.trim().isEmpty();
    }
}