package com.samant.Practice.Service;


import com.samant.Practice.Dao.UserRepository;
import com.samant.Practice.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> fetchUserDetails()
    {
      return  userRepository.findAll();
    }

    public User createUser(String username, String rawPassword) {



        User user = new User();
        user.setUserName(username);

        // IMPORTANT: encode password before saving
        user.setPassword(passwordEncoder.encode(rawPassword));



        return userRepository.save(user);
    }


}
