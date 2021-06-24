package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.dto.AuthorDTO;
import com.fon.knjizarafrontend.dto.CityDTO;
import com.fon.knjizarafrontend.fc.Author;
import com.fon.knjizarafrontend.service.AuthorService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@Controller
public class AuthorController {
    @Resource
    private AuthorService authorService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }

    @RequestMapping("/newAuthor")
    public String addAuthor(Model model){
        model.addAttribute("author",new AuthorDTO());
        return "addAuthorPage";
    }

    @RequestMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable Long id, Model model){
        ResponseEntity<Object> response = authorService.deleteAuthor(id);
        if(response.getStatusCode()== HttpStatus.OK) {
            model.addAttribute("redirectMessage", "Uspešno ste obrisali autora i njegova dela");
            return "forward:/mainPage";
        }
        return "";
    }

    @RequestMapping("/editAuthor/{id}")
    public String editAuthor(@PathVariable Long id, Model model){
        ResponseEntity<AuthorDTO> response = authorService.findAuthor(id);
        if(response.getStatusCode()== HttpStatus.OK) {
            model.addAttribute("author",response.getBody());
            return "editAuthorPage";
        }
        return "";
    }

    @RequestMapping(value = "/saveAuthor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveAuthor(AuthorDTO author, Model model){
        if(author.getFirstName() == null || author.getFirstName().isEmpty()
        || author.getLastName() ==null || author.getLastName().isEmpty()
        || author.getDateOfBirth() == null){
            model.addAttribute("errorMessage", "Niste uneli sve neophodne podatke!");
            model.addAttribute("author",author);
            return "addAuthorPage";
        }
        author.setBooks(new LinkedList<>());
        if (authorService.saveAuthor(author).getStatusCode() == HttpStatus.OK)
            return "redirect:/mainPage";
        return "";
    }

    @RequestMapping(value = "/changeAuthorInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateAuthor(AuthorDTO author, Model model){
        if(author.getFirstName() == null || author.getFirstName().isEmpty()
                || author.getLastName() ==null || author.getLastName().isEmpty()
                || author.getDateOfBirth() == null){
            model.addAttribute("errorMessage", "Niste uneli sve neophodne podatke!");
            model.addAttribute("author",author);
            return "editAuthorPage";
        }
        author.setBooks(new LinkedList<>());
        if (authorService.updateAuthor(author).getStatusCode() == HttpStatus.OK)
            return "redirect:/mainPage";
        return "";
    }
}
