package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("newBook")
    public String addBook(Model model){
        model.addAttribute("book",new BookDTO());
        return "addBookPage";
    }
}
