package com.SocialMedia.Instagram.Controller;

import com.SocialMedia.Instagram.Models.User;
import com.SocialMedia.Instagram.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("User")
public class UserController {


//     first add user then post then notification;
    @Autowired
    private UserService userService;


//    http://localhost:8080/User/addUser
    @PostMapping("addUser")
    public ResponseEntity<User> AddUser(@RequestBody User user){
        User user1 = userService.AddUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

//    http://localhost:8080/User/User-Most-Like-By-Post
    @GetMapping("User-Most-Like-By-Post")
    public ResponseEntity<User> UserMostLikesByPost(){
        User user = userService.UserMostLikesByPost();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
