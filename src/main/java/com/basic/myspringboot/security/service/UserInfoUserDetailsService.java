package com.basic.myspringboot.security.service;

import com.basic.myspringboot.security.model.UserInfo;
import com.basic.myspringboot.security.model.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //UserInfo 존재여부 체크
        Optional<UserInfo> optionalUserInfo = repository.findByEmail(email);
        // Optional map(Function<UserInfo,UserInfoUserDetails>)
        return //optionalUserInfo.map(userInfo -> new UserInfoUserDetails(userInfo))
                optionalUserInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));

    }

    public String addUser(UserInfo userInfo) {
        //Password 암호화
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        UserInfo savedUserInfo = repository.save(userInfo);
        return savedUserInfo.getName() + " user added!!";
    }
}