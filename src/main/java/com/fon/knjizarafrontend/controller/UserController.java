package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.dto.CityDTO;
import com.fon.knjizarafrontend.dto.UserDTO;
import com.fon.knjizarafrontend.editor.CityEditor;
import com.fon.knjizarafrontend.fc.ChangeUserInfo;
import com.fon.knjizarafrontend.service.CityService;
import com.fon.knjizarafrontend.service.UserService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private CityService cityService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private CityEditor cityEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(CityDTO.class, this.cityEditor);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }

    @RequestMapping("/userProfile")
    public String changeUserDetails(Model model){
        String username= (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ResponseEntity<UserDTO> userResponse=userService.findUserByUsername(username);
        UserDTO userDTO=userResponse.getBody();
        ChangeUserInfo user = new ChangeUserInfo();
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());
        user.setEmail(userDTO.getEmail());
        user.setLastName(userDTO.getLastName());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setRole(userDTO.getRole());
        user.setUserId(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());
        model.addAttribute("user",user);
        ResponseEntity<CityDTO[]> citiesResponse=cityService.findAllCities();
        model.addAttribute("cities",citiesResponse.getBody());
        return "changeProfileInfo";
    }

    @PostMapping(value = "/changeUserInfo" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    private String changeUserInfo(ChangeUserInfo user,Model model){
        String username= (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ResponseEntity<UserDTO> userResponse=userService.findUserByUsername(username);
        UserDTO userDTO=userResponse.getBody();
        ResponseEntity<CityDTO[]> citiesResponse=cityService.findAllCities();

        if(!passwordEncoder.matches(user.getOldPassword(),userDTO.getPassword())){
            model.addAttribute("user",user);
            model.addAttribute("cities",citiesResponse.getBody());
            model.addAttribute("errorPasswordMessage","Stara lozinka nije ispravna");
            return "changeProfileInfo";
        }

        if(!user.getPassword().equals(""))
            userDTO.setPassword(passwordEncoder.encode(user.getPassword()));

        if(!user.getAddress().equals(""))
            userDTO.setAddress(user.getAddress());

        if(!user.getName().equals(""))
            userDTO.setName(user.getName());

        if(!user.getEmail().equals(""))
            userDTO.setEmail(user.getEmail());

        if(!user.getLastName().equals(""))
            userDTO.setLastName(user.getLastName());

        if(!user.getPhone().equals(""))
            userDTO.setPhone(user.getPhone());

        ResponseEntity<Object> responseUserEdit=userService.updateUser(userDTO);
        if(responseUserEdit.getStatusCode()!= HttpStatus.OK){
            model.addAttribute("errorEditingInfoMessage","Doslo je do greske u izmeni podataka");
            model.addAttribute("user",user);
            return "changeProfileInfo";
        }
        model.addAttribute("redirectMessage","Uspesno ste izmenili podatke profila");
        return "forward:/mainPage";

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
        return "forward:/login";
    }
}
