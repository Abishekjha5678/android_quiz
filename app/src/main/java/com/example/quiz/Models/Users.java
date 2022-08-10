package com.example.quiz.Models;

public class Users {
        String email,name,password,mobile,profilepic;
    public Users(String email, String name, String password, String mobile, String profilepic) {

        this.email = email;
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.profilepic = profilepic;
    }

    public Users(String email, String name, String password,String mobile) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.mobile=mobile;
    }

    public Users() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }




}
