import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository implements Repository<User, Long>{
    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User entity) {
        users.add(entity);

    }

    public User findById(Long id) {
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }

            }
        return null;
    }

    public List<User> findAll(){
        return new ArrayList<>(users);
    }

}