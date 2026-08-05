public class UserValidationService  {



    public boolean isAdult(User2 user){
        if(this.age == null){
            throw new IllegalArgumentException("年龄不可为空");
        }if(this.age < 0){
            throw new IllegalArgumentException("年龄不可为0");
        }if(this.age > 18){
            return true;
        }else {
            return false;
        }

    }

    public boolean isValidUsername(User2 user){
        if(this.username == null){
            throw new IllegalArgumentException("用户名不可为空");
        }if(this.username == "" || this.username == " "){
            throw new IllegalArgumentException("用户名不可为空")
        }else {
            return true;
        }
    }
}
