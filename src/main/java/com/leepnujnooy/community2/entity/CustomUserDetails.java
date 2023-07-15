package com.leepnujnooy.community2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Builder
@AllArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails {

    public Long id;
    public String username;
    public String password;
    public String nickname;
    public String address;

    public static UserEntity convertUserDetailToUserEntity (CustomUserDetails userDetails){
        return UserEntity
                .builder()
                .username(userDetails.getUsername())
                .password(userDetails.getPassword())
                .nickname(userDetails.getNickname())
                .address(userDetails.getAddress())
                .build();
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
