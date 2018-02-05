package com.roamer.spittr.security;

import com.roamer.spittr.dao.SpitterRepository;
import com.roamer.spittr.pojo.Spitter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author roamer
 * @version V1.0
 * @date 2018/1/17
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SpitterRepository spitterRepository;

    public UserDetailsServiceImpl(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Spitter spitter = spitterRepository.findByUsername(username);
        if (null == spitter) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();
        //创建权限列表
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(spitter.getUsername(), spitter.getPassword(), authorityList);
    }
}
