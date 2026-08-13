public class UserVO {
    private Long id;
    private String username;
    private String cratedAt;

    public UserVO(Long id, String username, String cratedAt) {
        this.id = id;
        this.username = username;
        this.cratedAt = cratedAt;
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
    public String getCratedAt() {
        return cratedAt;
    }
    public void setCratedAt(String cratedAt) {
        this.cratedAt = cratedAt;
    }


}
