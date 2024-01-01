package com.mysite.site1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stars")
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column
    String description;

    @Column
    String height;

    @ManyToMany(mappedBy = "favouriteStars")
    private List<User> users = new ArrayList<>();

    @Column
    String photoUrls;


    public Star(Long id, String name, String description, String height, List<User> users, String photoUrls) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.height = height;
        this.users = users;
        this.photoUrls = photoUrls;
    }

    public Star(){}
}
