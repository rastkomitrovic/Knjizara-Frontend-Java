package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.constants.Language;
import com.fon.knjizarafrontend.dto.AuthorDTO;
import com.fon.knjizarafrontend.dto.GenreDTO;
import com.fon.knjizarafrontend.dto.PublisherDTO;
import com.fon.knjizarafrontend.fc.Book;
import com.fon.knjizarafrontend.service.AuthorService;
import com.fon.knjizarafrontend.service.BookService;
import com.fon.knjizarafrontend.service.GenreService;
import com.fon.knjizarafrontend.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

    }

    @RequestMapping("/newBook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());

        ResponseEntity<PublisherDTO[]> publishersResponse = publisherService.getAllPublishers();
        ResponseEntity<AuthorDTO[]> authorsResponse = authorService.findAllAuthorsNoPaging();
        ResponseEntity<GenreDTO[]> genresResponse = genreService.getAllGenresNoPaging();
        model.addAttribute("errorMessage", "");
        if (publishersResponse.getStatusCode() == HttpStatus.OK && authorsResponse.getStatusCode() == HttpStatus.OK && genresResponse.getStatusCode() == HttpStatus.OK) {
            model.addAttribute("publishers", Arrays.asList(publishersResponse.getBody()));
            model.addAttribute("authors", Arrays.asList(authorsResponse.getBody()));
            model.addAttribute("genres", Arrays.asList(genresResponse.getBody()));
            model.addAttribute("languages", Language.values());
            return "addBookPage";
        }
        return "errorPage";

    }

    @PostMapping(path = "/saveBook", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveBook(Book book, Model model) {
        if (book.getAuthors().isEmpty() || book.getBookName().isEmpty() ||
                book.getDescription().isEmpty() || book.getGenres().isEmpty() || book.getImages().isEmpty() ||
                book.getIsbn().isEmpty() || book.getPrice() <= 0 || book.getStock() <= 0){
            model.addAttribute("errorMessage", "Niste uneli sve neophodne podatke!");
            model.addAttribute("book", book);

            ResponseEntity<PublisherDTO[]> publishersResponse = publisherService.getAllPublishers();
            ResponseEntity<AuthorDTO[]> authorsResponse = authorService.findAllAuthorsNoPaging();
            ResponseEntity<GenreDTO[]> genresResponse = genreService.getAllGenresNoPaging();

            if (publishersResponse.getStatusCode() == HttpStatus.OK && authorsResponse.getStatusCode() == HttpStatus.OK && genresResponse.getStatusCode() == HttpStatus.OK) {
                model.addAttribute("publishers", Arrays.asList(publishersResponse.getBody()));
                model.addAttribute("authors", Arrays.asList(authorsResponse.getBody()));
                model.addAttribute("genres", Arrays.asList(genresResponse.getBody()));
                model.addAttribute("languages", Language.values());
                return "addBookPage";
            }
        }
        ResponseEntity<Object> responseEntity=bookService.saveBook(book);
        if(responseEntity.getStatusCode()==HttpStatus.OK)
            return "redirect:/mainPage";
        return "errorPage";
    }
}
