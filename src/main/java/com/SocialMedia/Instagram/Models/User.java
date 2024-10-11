package com.SocialMedia.Instagram.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String age;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Post> posts;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Notification> notifications;

}
