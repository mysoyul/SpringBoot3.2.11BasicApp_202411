package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.UserEntity;
import com.basic.myspringboot.exception.BusinessException;
import com.basic.myspringboot.repository.CustomerRepository;
import com.basic.myspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {
    private final UserRepository userRepository;

    //Constructor Injection
//    public UserRestController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @PostMapping
    public UserEntity create(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return getUserNotFound(id);
    }

    @GetMapping
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @PatchMapping("/email/{email}/")
    public UserEntity updateUser(@PathVariable String email, @RequestBody UserEntity userDetail) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));

        user.setName(userDetail.getName());
        return userRepository.save(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        UserEntity user = getUserNotFound(id);
        userRepository.delete(user);
        return ResponseEntity.ok("ID = " + id + " User Deleted OK");
    }

    private UserEntity getUserNotFound(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
    }
}
