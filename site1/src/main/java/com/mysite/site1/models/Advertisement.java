package com.mysite.site1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "advertisements")
public class Advertisement {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        @Column
        String name;

        @Column
        String adsGifUrl;

        @Column
        String affiliateLinkUrl;

        public Advertisement(Long id, String name, String adsGifUrl, String affiliateLinkUrl) {
                this.id = id;
                this.name = name;
                this.adsGifUrl = adsGifUrl;
                this.affiliateLinkUrl = affiliateLinkUrl;
        }

        public Advertisement() {
        }
}



