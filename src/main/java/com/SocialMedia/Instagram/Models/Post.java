package com.SocialMedia.Instagram.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(updatable = false)
    private LocalDateTime time = LocalDateTime.now(); // Set default to current date and time

    @Column(name = "likes")
    private int likeCount;

    @ManyToOne
    private User user;

    @PrePersist
    protected void onCreate() {
        this.time = LocalDateTime.now(); // Ensure the time is set when the entity is created
    }
}
