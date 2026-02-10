package com.samant.Practice.Controller;


import com.samant.Practice.Dao.UserRepository;
import com.samant.Practice.Model.User;
import com.samant.Practice.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/fetch-all-users")
    public ResponseEntity<List<User>> fetchUsers()
    {
        return new ResponseEntity<>(userService.fetchUserDetails(), HttpStatus.OK);
    }

    @PostMapping("/add-users")
    public ResponseEntity<User>createUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.createUser(user.getUserName(),user.getPassword()),HttpStatus.OK);
    }


}
