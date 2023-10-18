package com.mysite.site1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "singleContents")
public class SingleContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String description;

    @Column
    String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column
    int likes;

    @Column
    int views;

    @OneToMany(mappedBy = "singleContent", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"singleContent"})
    List<Comment> commentList;

}
