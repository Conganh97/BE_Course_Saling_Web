package com.hoixuan.be_course_saling_web.service.UserService;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.repository.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public  class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return userRepository.findById(id);
    }



    @Override
    public AppUser save(AppUser appUser) {
        return userRepository.save(appUser);
    }

    @Override
    public void remove(Long idUser) {
        userRepository.deleteById(idUser);
    }
}
