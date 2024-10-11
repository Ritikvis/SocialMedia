package com.SocialMedia.Instagram.Controller;

import com.SocialMedia.Instagram.Models.Post;
import com.SocialMedia.Instagram.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Post")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("addPost")
    public ResponseEntity<Post> AddPost(@RequestBody Post post){
        Post post1 = postService.AddPost(post);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }
    @PostMapping("addUserPost")
    public ResponseEntity<Void> AddUserPost(@RequestParam Long postId,@RequestParam Long userId){
        postService.AddUserPost(postId,userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("updateLike/{postId}/{likeCount}")
    public ResponseEntity<Void> UpdateLikes(@PathVariable Long postId,@PathVariable int likeCount){
        postService.UpdateLikes(postId,likeCount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
