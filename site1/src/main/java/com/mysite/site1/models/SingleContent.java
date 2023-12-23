package com.mysite.site1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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

    public SingleContent(Long id, String title, String description, String url, User user, int likes, int views, List<Comment> commentList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.user = user;
        this.likes = likes;
        this.views = views;
        this.commentList = commentList;
    }

    public SingleContent() {
    }
}
