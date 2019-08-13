package com.SpringBasicRest.BasicRest.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel("All the important Information regarding the user")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size (min = 3, message = "Please input at least 3 letters")
    @ApiModelProperty(notes = "The name should have at least 3 character")
    private String name;

    @Past
    @ApiModelProperty(notes="Date of Birth should contain dates from the past only")
    private Date BirthData;

    @OneToMany(mappedBy="user")
    private List<Post> posts;


    protected User(){}

    public User(Integer id, String name, Date birthData) {
        super();
        this.id = id;
        this.name = name;
        BirthData = birthData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthData() {
        return BirthData;
    }

    public void setBirthData(Date birthData) {
        BirthData = birthData;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", BirthData=" + BirthData +
                '}';
    }
}
