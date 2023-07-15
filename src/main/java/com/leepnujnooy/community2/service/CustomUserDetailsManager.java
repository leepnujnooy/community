package com.leepnujnooy.community2.service;

import com.leepnujnooy.community2.entity.UserEntity;
import com.leepnujnooy.community2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsManager implements UserDetailsManager {

    private final UserService userService;
    private final UserRepository userRepository;
    @Override
    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optional = userRepository.findByUsername(username);
        if(optional.isEmpty()){
            throw new UsernameNotFoundException(username);

        }

        //userdetails 가 리턴
        return UserEntity.convertUserEntityToUserDetails(optional.get());
    }

    @Override
    public void createUser(UserDetails user) {
        if(userExists(user.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        else{
            //유저 서비스
            userService.createUser(user);
        }
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }


}
