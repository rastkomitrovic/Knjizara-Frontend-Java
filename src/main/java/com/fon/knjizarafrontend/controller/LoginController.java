package com.fon.knjizarafrontend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fon.knjizarafrontend.fc.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;


@Controller
public class LoginController {

    @RequestMapping("/loginFailed")
    public String errorLogin(Model model) throws JsonProcessingException {
        LoginUser loginUser = new LoginUser();
        model.addAttribute("user", loginUser);
        model.addAttribute("message", "Ne postoji korisnik sa unetim kredencijalima");
        return "loginPage";
    }

    @RequestMapping("/logoutSuccess")
    public String logout(Model model) throws JsonProcessingException {
        LoginUser loginUser = new LoginUser("", "");
        model.addAttribute("user", loginUser);
        ObjectMapper objectMapper = new ObjectMapper();
        return "loginPage";
    }

    @RequestMapping("/login")
    public String getLoginPage(Model model) throws JsonProcessingException, ParseException {
        LoginUser loginUser = new LoginUser("rastko", "rastko");
        model.addAttribute("user", loginUser);

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
