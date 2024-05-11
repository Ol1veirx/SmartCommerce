package com.github_ol1veirx.smartcommerce.Services;

import com.github_ol1veirx.smartcommerce.Entities.Role;
import com.github_ol1veirx.smartcommerce.Entities.User;
import com.github_ol1veirx.smartcommerce.Projections.UserDetailsProjections;
import com.github_ol1veirx.smartcommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjections> result = userRepository.searchUserAndRolesByEmail(username);
        if(result.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = new User();
        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());
        for (UserDetailsProjections projections : result) {
            user.addRole(new Role(projections.getRoleId(), projections.getAuthority()));
        }

        return user;
    }
}
