package com.hoixuan.be_course_saling_web.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.hoixuan.be_course_saling_web.model.dto.AccLogin;
import com.hoixuan.be_course_saling_web.model.dto.TokenDto;
import com.hoixuan.be_course_saling_web.model.dto.UserToken;
import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Role;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.JwtService;
import com.hoixuan.be_course_saling_web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("auth")
public class LoginAPI {

    @Value("${google.id}")
    private String idClient;

    @Value("${mySecret.password}")
    private String password;

    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AppUserService appUserService;

    private String email;

    private PasswordEncoder passwordEncoder;

    private RoleService roleService;



    @PostMapping("/login")
    public UserToken login(@RequestBody AccLogin accLogin){
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(accLogin.getEmail(), accLogin.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtService.createToken(authentication);
            AppUser appUser1 = appUserService.findByUserName(accLogin.getEmail());
            return new UserToken(appUser1.getIdUser(),appUser1.getUserName(),token,appUser1.getRoles());
        } catch (Exception e) {
            return null;
        }

    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser){
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(2);
        roles.add(role);
        appUser.setRoles(roles);
        return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.OK);
    }

    @PostMapping("/google")
    public ResponseEntity<UserToken> loginWithGoogle(@RequestBody TokenDto tokenDto) throws IOException {
        NetHttpTransport transport = new NetHttpTransport();

        JacksonFactory factory = JacksonFactory.getDefaultInstance();

        GoogleIdTokenVerifier.Builder ver =
                new GoogleIdTokenVerifier.Builder(transport,factory)
                        .setAudience(Collections.singleton(idClient));
        GoogleIdToken googleIdToken = GoogleIdToken.parse(ver.getJsonFactory(),tokenDto.getToken());
        GoogleIdToken.Payload payload = googleIdToken.getPayload();

        email = payload.getEmail();
        AppUser appUser = new AppUser();

        if (appUserService.ifEmailExist(email)){
            appUser = appUserService.getUserByMail(email);
        }else {
            appUser = createUser(email);
        }

        AccLogin accLogin = new AccLogin();
        accLogin.setEmail(appUser.getEmail());
        accLogin.setPassword(password);

        return new ResponseEntity<UserToken>(login(accLogin), HttpStatus.OK);


    }

    private AppUser createUser(String email){
        AppUser appUser = new AppUser();
        appUser.setEmail(email);
        appUser.setPassword(passwordEncoder.encode(password));
        List<Role> roles = roleService.getRoles();
        appUser.getRoles().add(roles.get(0));
        return appUserService.save(appUser);
    }

    

}
