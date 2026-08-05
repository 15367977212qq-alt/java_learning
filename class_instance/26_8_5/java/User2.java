public class User2 {
    private Integer id;
    private String username;
    private Integer age;
    private String status;

    public User2(Integer id, String username, Integer age, String status) {
        this.id = id;
        this.username = username;
    }


    public boolean equals(){
        return this.id.equals(this.id);
    }


}
