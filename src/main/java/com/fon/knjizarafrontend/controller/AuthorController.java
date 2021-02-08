package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.dto.AuthorDTO;
import com.fon.knjizarafrontend.fc.Author;
import com.fon.knjizarafrontend.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class AuthorController {
    @Resource
    private AuthorService authorService;

    @RequestMapping("/newAuthor")
    public String addAuthor(Model model){
        model.addAttribute("author",new Author());
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
}
