package com.atguigu.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//OID对象在内存中的ID，有唯一性

    // 用户名
//    @Column(name = "username")
    private String username;

    // 密码
//    @Column(name = "password")
    private String password;

    // 姓名
//    @Column(name = "name")
    private String name;


    private Integer age;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
