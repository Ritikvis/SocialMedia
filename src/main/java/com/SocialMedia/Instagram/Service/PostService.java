package com.SocialMedia.Instagram.Service;

import com.SocialMedia.Instagram.Models.Post;
import com.SocialMedia.Instagram.Models.User;
import com.SocialMedia.Instagram.Repository.PostRepository;
import com.SocialMedia.Instagram.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationService notificationService;


    public Post addUserWithPost(Post post, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("Id not found"));
        post.setUser(user);

        return  postRepository.save(post);

    }


    public void UpdateLikes(Long postId, int likeCount) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("Id not fond : " + postId));
        post.setLikeCount(likeCount);
        postRepository.save(post);
        notificationService.sendLikeNotification(post);
    }
}
