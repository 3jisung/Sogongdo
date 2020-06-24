package model;

import java.sql.Date;

public class User {
    private String id;
    private String password;
    private String name;
    private String address;
    private Date birth;
    private String phoneNumber;
    private String email;
    private int UserTypeCode_code;

    public User() {
    }

    public User(String id, String password, String name, String address, Date birth, String phoneNumber, String email,
                int userTypeCode_code) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.UserTypeCode_code = userTypeCode_code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserTypeCode_code() {
        return UserTypeCode_code;
    }

    public void setUserTypeCode_code(int userTypeCode_code) {
        UserTypeCode_code = userTypeCode_code;
    }


}
