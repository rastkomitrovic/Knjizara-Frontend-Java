package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.auth.BookStoreAuthenticationProvider;
import com.fon.knjizarafrontend.dto.CityDTO;
import com.fon.knjizarafrontend.dto.UserDTO;
import com.fon.knjizarafrontend.fc.LoginUser;
import com.fon.knjizarafrontend.service.CityService;
import com.fon.knjizarafrontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private BookStoreAuthenticationProvider bookStoreAuthenticationProvider;


    @RequestMapping("/loginFailed")
    public String errorLogin(Model model){
        LoginUser loginUser=new LoginUser();
        model.addAttribute("user",loginUser);
        model.addAttribute("message","Ne postoji korisnik sa unetim kredencijalima");
        return "loginPage";
    }

    @RequestMapping("/logoutSuccess")
    public String logout(Model model){
        LoginUser loginUser=new LoginUser();
        model.addAttribute("user",loginUser);
        model.addAttribute("message","Uspesno ste se izlogovali");
        return "loginPage";
    }
    @RequestMapping("/login")
    public String getLoginPage(Model model) throws ParseException {
        LoginUser loginUser=new LoginUser();
        model.addAttribute("user",loginUser);
        return "loginPage";
    }

    /*@PostMapping("/performLogin")
    public String authenticateUser(
            HttpServletRequest request,
            @Valid @ModelAttribute("user") LoginUser user,
            BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "loginPage";

        UsernamePasswordAuthenticationToken authReq=new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication auth=bookStoreAuthenticationProvider.authenticate(authReq);

        SecurityContext securityContext= SecurityContextHolder.getContext();
        securityContext.setAuthentication(auth);
        HttpSession session= request.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,securityContext);
        return "index";
    }*/
}
