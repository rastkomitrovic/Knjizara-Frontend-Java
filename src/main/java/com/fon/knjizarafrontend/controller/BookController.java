package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.dto.AuthorDTO;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.dto.GenreDTO;
import com.fon.knjizarafrontend.dto.PublisherDTO;
import com.fon.knjizarafrontend.fc.Book;
import com.fon.knjizarafrontend.service.AuthorService;
import com.fon.knjizarafrontend.service.BookService;
import com.fon.knjizarafrontend.service.GenreService;
import com.fon.knjizarafrontend.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Arrays;

@Controller
public class BookController {

    @Resource
    private BookService bookService;

    @Resource
    private PublisherService publisherService;

    @Resource
    private AuthorService authorService;

    @Resource
    private GenreService genreService;


    @RequestMapping("/newBook")
    public String addBook(Model model){
        model.addAttribute("book",new Book());

        ResponseEntity<PublisherDTO[]> publishersResponse=publisherService.getAllPublishers();
        ResponseEntity<AuthorDTO[]> authorsResponse=authorService.findAllAuthorsNoPaging();
        ResponseEntity<GenreDTO[]> genresResponse=genreService.getAllGenresNoPaging();

        if(publishersResponse.getStatusCode()== HttpStatus.OK && authorsResponse.getStatusCode()==HttpStatus.OK && genresResponse.getStatusCode()==HttpStatus.OK){
            model.addAttribute("publishers", Arrays.asList(publishersResponse.getBody()));
            model.addAttribute("authors", Arrays.asList(authorsResponse.getBody()));
            model.addAttribute("genres",Arrays.asList(genresResponse.getBody()));
            return "addBookPage";
        }
        return "errorPageNewBook";

    }
}
