package com.leepnujnooy.community2.service;


import com.leepnujnooy.community2.entity.CustomUserDetails;
import com.leepnujnooy.community2.entity.UserEntity;
import com.leepnujnooy.community2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserDetails userDetails){
        userRepository.save(CustomUserDetails.convertUserDetailToUserEntity((CustomUserDetails) userDetails));
    }

}
