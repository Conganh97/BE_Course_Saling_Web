package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Role;
import com.hoixuan.be_course_saling_web.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAppUserRepo iAppUserRepo;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepo.findByUserNameS(username);
        return new User(appUser.getUserName(), appUser.getPassword(), appUser.getRoles());
    }
    public List<AppUser> getAll(){
        return (List<AppUser>) iAppUserRepo.findAll();
    }

    public AppUser findByUserName(String username){
        AppUser appUser = iAppUserRepo.findByUserName(username);
        return appUser;
    }

    public AppUser findByEMail(String email){
        return iAppUserRepo.findByEmail(email);
    }

    public AppUser save(AppUser appUser){
        return iAppUserRepo.save(appUser);
    }

    public void delete(long id){
     iAppUserRepo.deleteById(id);
    }
}
