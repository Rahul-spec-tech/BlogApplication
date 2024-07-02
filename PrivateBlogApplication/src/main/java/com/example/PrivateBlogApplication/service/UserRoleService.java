//package com.example.PrivateBlogApplication.service;
//
//import java.util.Optional;
//
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
////
////import com.example.PrivateBlogApplication.model.UserRole;
////import com.example.PrivateBlogApplication.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.PrivateBlogApplication.model.UserRole;
//import com.example.PrivateBlogApplication.repository.UserRepository;
//
//public class UserRoleService implements UserDetailsService {
//	 
//	    private UserRepository userRepo;
//
//	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	        Optional<UserRole> user =userRepo.findByUsername(username);
//	        if (user.isPresent()) {
//	            var userObj = user.get();
//	            return User.builder()
//	                    .username(userObj.getUsername())
//	                    .password(userObj.getPassword())
//	                    .isPrivate(getRoles(userObj))
//	                    .build();
//	        } else {
//	            throw new UsernameNotFoundException(username);
//	        }
//	    }
//
//	    private String getRoles(UserRole user) {
//	    	String x="";
//	        if (user.isIsPrivate() == true) {
//	            x+="PRIVATE";
//	        }
//	        else {
//	        	x+="PUBLIC";
//	        }
//	        return x;
//	    }
//}

package com.example.PrivateBlogApplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.PrivateBlogApplication.model.UserRole;
import com.example.PrivateBlogApplication.repository.UserRepository;

@Service
public class UserRoleService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserRole> user = userRepo.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .authorities(getRoles(userObj))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String getRoles(UserRole user) {
        if (user.isIsPrivate()) {
            return "ROLE_PRIVATE";
        } else {
            return "ROLE_PUBLIC";
        }
    }
}
