package org.user.dao.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "neighbor")
public class Neighbor {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;
    private Integer apartament;

    public Neighbor() {}

    public Neighbor(String name, Integer age, String email, Integer apartament) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.apartament = apartament;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getApartament() {
        return apartament;
    }

    public void setApartament(Integer apartament) {
        this.apartament = apartament;
    }

    @Override
    public String toString() {
        return "Neighbor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", apartament=" + apartament +
                '}';
    }
}
