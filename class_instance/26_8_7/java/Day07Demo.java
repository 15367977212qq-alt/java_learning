import com.sun.corba.se.impl.activation.RepositoryImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Day07Demo {
    public static void main(String[] args) {
        User user = new User(
                1L,
                "Tommy",
                20,
                "ACTIVE",
                LocalDateTime.now()
        );
        Repository repo = new UserRepository();
        UserService userService = new UserService(repo);
        repo.save(user);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);
        LocalDateTime oneHourAgo = now.minusHours(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        String formatted = user.getCreatedAt().format(formatter);

        List<UserVO> result = userService.getActiveUserVOs();

        ApiResponse<List<UserVO>> response = ApiResponse.success(result);

        System.out.println(response);







    }


}
