import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class UserService {

    private final Repository<User, Long> repository;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public UserService(
            Repository<User, Long> repository
    ) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public Optional<User> findUser(Long id) {
        return Optional.ofNullable(
                repository.findById(id)
        );
    }

    public List<User> findAllUser() {
        return repository.findAll();
    }

    public User getRequiredUser(Long id) {
        return findUser(id).orElseThrow(
                () -> new BusinessException(
                        "USER_NOT_FOUND",
                        "用户不存在"
                )
        );
    }

    public List<User> filterUsers(
            List<User> users,
            UserFilter filter
    ) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (filter.test(user)) {
                result.add(user);
            }
        }
        return result;
    }

    public List<UserVO> getActiveUserVOs() {

        return repository.findAll().stream()
                .filter(user -> "ACTIVE".equals(user.getStatus()))
                .map(user -> new UserVO(user.getId()
                        , user.getUsername()
                        , user.getCreatedAt().format(formatter)))
                .sorted(Comparator.comparing(UserVO::getUsername).reversed())
                .collect(Collectors.toList());
    }

    public Map<Long, User> buildUSerMap(List<User> users) {
        Map<Long, User> result = new HashMap<>();
        for (User u : users) {
            result.put(u.getId(), u);
        }
        return result;


    }

    public static Map<String,Integer> countByStatus(List<User> users){
        Map<String,Integer> countmap = new HashMap<>();
        for (User user : users) {
            String status = user.getStatus();
            countmap.put(status,countmap.getOrDefault(status,0) + 1);

        }
        return countmap;
    }

    public static  Map<String,List<User>> groupByStatus(List<User> users){
        Map<String,List<User>> result = new HashMap<>();
        for(User user: users){
            result.computeIfAbsent(user.getStatus() ,k -> new ArrayList<>()).add(user);
        }
        if(result.containsKey("ACTIVE")){
            return result;
        }
        if(result.containsKey("INACTIVE")){
            return result;
        }
        return result;
    }
}