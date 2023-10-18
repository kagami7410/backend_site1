package com.mysite.site1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String comment;

    @ManyToOne
    @JoinColumn(name = "singleContent_id")
    SingleContent singleContent;

}
