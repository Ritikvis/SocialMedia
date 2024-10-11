package com.SocialMedia.Instagram.Service;

import com.SocialMedia.Instagram.Models.Notification;
import com.SocialMedia.Instagram.Models.Post;
import com.SocialMedia.Instagram.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    public void sendLikeNotification(Post post) {
        Notification notification = new Notification();
        notification.setTime(LocalDateTime.now());
        notification.setUser(post.getUser());
        notification.setPost(post);
        notificationRepository.save(notification);
    }
}
