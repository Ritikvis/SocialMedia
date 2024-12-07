package com.SocialMedia.Instagram.Controller;

import com.SocialMedia.Instagram.Models.Post;
import com.SocialMedia.Instagram.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Post")
public class PostController {
    @Autowired
    private PostService postService;

//    http://localhost:8080/Post/addUserWithPost/1
    @PostMapping("/addUserWithPost/{userId}")
    public ResponseEntity<Post> addUserWithPost(@RequestBody Post post, @PathVariable Long userId) {
        System.out.println("This is user id"+userId);
        Post savedPost = postService.addUserWithPost(post, userId);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

//    http://localhost:8080/Post/updateLike/1/20
    @PutMapping("updateLike/{postId}/{likeCount}")
    public ResponseEntity<Void> UpdateLikes(@PathVariable Long postId,@PathVariable int likeCount){
        postService.UpdateLikes(postId,likeCount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
