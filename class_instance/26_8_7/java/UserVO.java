public class UserVO {
    private Long id;
    private String username;
    private String createdAt;

    public UserVO(Long id, String username, String createdAt) {
        this.id = id;
        this.username = username;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}
    public String getUsername() {
        return username;
    }
    public void setUsername(String userame) {
        this.username = userame;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String cratedAt) {
        this.createdAt = cratedAt;
    }


}
