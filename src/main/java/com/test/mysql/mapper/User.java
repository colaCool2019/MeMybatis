package com.test.mysql.mapper;

/**
 * @ClassName User
 * @Description User
 * @Author liyz
 * @Date 2020/5/15 14:37
 * @Version 1.0
 */
public class User {

    private String id;

    private String name;

    private String phone;

    private String test;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", test='" + test + '\'' +
                '}';
    }
}
