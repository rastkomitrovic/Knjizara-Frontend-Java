package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.dto.CityDTO;
import com.fon.knjizarafrontend.dto.UserDTO;
import com.fon.knjizarafrontend.editor.CityEditor;
import com.fon.knjizarafrontend.service.CityService;
import com.fon.knjizarafrontend.service.UserService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Controller
public class RegisterController {
    @Resource
    private UserService userService;

    @Resource
    private CityService cityService;

    @Resource
    private CityEditor cityEditor;

    @Resource
    private PasswordEncoder passwordEncoder;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
        binder.registerCustomEditor(CityDTO.class, this.cityEditor);
    }

    @RequestMapping("/newUser")
    public String register(Model model) {
        model.addAttribute("user", new UserDTO());
        ResponseEntity<CityDTO[]> responseEntity = cityService.findAllCities();
        if (responseEntity.getStatusCode() == HttpStatus.OK)
            model.addAttribute("cities", Arrays.asList(responseEntity.getBody()));
        return "registration";
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String register(UserDTO user, Model model) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        ResponseEntity<Object> responseEntity = userService.saveUser(user);
        if (responseEntity.getStatusCode() == HttpStatus.FOUND) {
            model.addAttribute("user", user);
            model.addAttribute("errorMessage", "Vec postoji korisnik sa tim korisnickim imenom");
            user.setPassword("");
            return "registration";
        }
        return "index";
    }
}
