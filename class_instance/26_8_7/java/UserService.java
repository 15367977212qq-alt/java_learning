import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService {

    private final Repository<User, Long> repository;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public UserService(
            Repository<User, Long> repository
    ){
        this.repository = repository;
    }

    public void saveUser(User user){
        repository.save(user);
    }

    public Optional<User> findUser(Long id){
        return Optional.ofNullable(
                repository.findById(id)
        );
    }

    public List<User> findAllUser(){
        return repository.findAll();
    }

        public User getRequiredUser(Long id){
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
    ){
        List<User> result = new ArrayList<>();
        for(User user : users){
            if(filter.test(user)){
                result.add(user);
            }
        }return result;
    }

    public List<UserVO> getActiveUserVOs(){

        return repository.findAll().stream()
                .filter(user -> "ACTIVE".equals(user.getStatus()))
                .map(user -> new UserVO(user.getId()
                        ,user.getUsername()
                        ,user.getCreatedAt().format(formatter)))
                .sorted(Comparator.comparing(UserVO::getUsername).reversed())
                .collect(Collectors.toList());
    }



}