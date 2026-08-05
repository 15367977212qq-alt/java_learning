package service;

import model.User;

public class UserService {


    public User createUser(Long id, String name, Integer age, String status) throws IllegalAccessException {
        if(!legalname(name)){
            throw new IllegalArgumentException("用户名不能为空");
        }
        if(!isAdult(age)){
            throw new IllegalArgumentException("用户年龄不合规");
        }

        User user = new User(id, name, age, status);

        return user ;

    }

    public void updateUser(User user, String status) {
        if (user == null) {
            throw new IllegalArgumentException("用户不能为空");
        }

        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("状态不能为空");
        }
        user.setStatus(status);
    }

    public  boolean isAdult(Integer age) {
        if (age <= 0 ){return true;}
        else{return false;}
    }

    public  boolean legalname(String name ) {
        if (name == null){return false;}
        else{return true;}
    }
}
