import java.util.Objects;

public class User {
    private  Long id;
    private  String username;
    private  Integer age;
    private  String status;

    public User(Long id, String username, Integer age, String active){
        this.id = id;
        this.username = username;
        this.age = age;
        this.status = active;
    }

    public User(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "user{" + username + ", id=" + id + ", age=" + age + ", status=" + status + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }


        User other = (User) obj;
        return Objects.equals(id,other.id);

    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
