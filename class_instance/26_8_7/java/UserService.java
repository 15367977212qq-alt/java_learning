public class UserService {

    public User createUser(Long id, String username, Integer age) {

        // 1. 校验用户ID
        if (id == null) {
            throw new BusinessException(
                    "ID_REQUIRED",
                    "用户ID不能为空"
            );
        }

        // 2. 校验用户名
        if (username == null || username.trim().isEmpty()) {
            throw new BusinessException(
                    "USERNAME_REQUIRED",
                    "用户名不能为空"
            );
        }

        // 3. 校验年龄是否为空
        if (age == null) {
            throw new BusinessException(
                    "AGE_REQUIRED",
                    "年龄不能为空"
            );
        }

        // 4. 校验年龄范围
        if (age < 0) {
            throw new BusinessException(
                    "INVALID_AGE",
                    "年龄不能小于0"
            );
        }

        // 5. 参数合法后创建用户，默认状态为ACTIVE
        return new User(
                id,
                username,
                age,
                "ACTIVE"
        );
    }

    public void disableUser(User user) {

        // 1. 校验用户对象
        if (user == null) {
            throw new BusinessException(
                    "USER_REQUIRED",
                    "用户不能为空"
            );
        }

        // 2. 判断用户是否已经被禁用
        if ("DISABLED".equals(user.getStatus())) {
            throw new BusinessException(
                    "USER_ALREADY_DISABLED",
                    "用户已经处于禁用状态"
            );
        }

        // 3. 修改用户状态
        user.setStatus("DISABLED");
    }
}