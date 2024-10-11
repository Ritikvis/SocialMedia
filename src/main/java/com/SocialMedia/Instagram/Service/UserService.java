package com.SocialMedia.Instagram.Service;

import com.SocialMedia.Instagram.Models.Post;
import com.SocialMedia.Instagram.Models.User;
import com.SocialMedia.Instagram.Repository.PostRepository;
import com.SocialMedia.Instagram.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    public User AddUser(User user) {
        return userRepository.save(user);
    }

    public User UserMostLikesByPost() {
        List<User> users = userRepository.findAll();
        int maxlikes =0;
        User userByMostLikes = users.get(0);
        for(User user : users){
            for(Post post : user.getPosts()){
                if(post.getLikeCount() > maxlikes){
                    maxlikes = post.getLikeCount();
                    userByMostLikes = post.getUser();
                }
            }
        }
        return userByMostLikes;

    }
}
