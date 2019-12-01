package com.mysql.mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mysql.mysql.dao.api.UserDAO;
import com.mysql.mysql.model.AppUser;
import com.mysql.mysql.model.Role;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserDAO userDB;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<AppUser> findAll() {
        Iterable<AppUser> allUsers = userDB.findAll();
        ArrayList<AppUser> users = new ArrayList<AppUser>();
        allUsers.forEach(user -> users.add(user));
        return users;
    }

    public long count() {
        return userDB.count();
    }

    public void deleteById(int userId) {
        userDB.deleteById(userId);
    }

    public void addUser(AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDB.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        AppUser user = userDB.findByUsername(username).orElseThrow(() -> {
            return new UsernameNotFoundException("User does not exist.");
        });
        
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        for (Role role: user.getUserRoles()) {
            GrantedAuthority grantedRole = new SimpleGrantedAuthority(role.getRole());
                grantList.add(grantedRole);
        }

        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantList);
        return userDetails;
    }
}
