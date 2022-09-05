package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean ifEmailExist(String mail){
        return iAppUserRepo.existsByEmail(mail);
    }

    public AppUser getUserByMail(String mail){
        return iAppUserRepo.findByEmail(mail);
    }

    public AppUser save(AppUser appUser){
        return iAppUserRepo.save(appUser);
    }

    public void delete(long id){
     iAppUserRepo.deleteById(id);
    }
}
