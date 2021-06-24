package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.constants.Language;
import com.fon.knjizarafrontend.constants.PageConstants;
import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.constants.SearchType;
import com.fon.knjizarafrontend.dto.AuthorDTO;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.dto.GenreDTO;
import com.fon.knjizarafrontend.dto.PublisherDTO;
import com.fon.knjizarafrontend.fc.Book;
import com.fon.knjizarafrontend.fc.Comment;
import com.fon.knjizarafrontend.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.security.Principal;
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

    @Resource
    private CommentService commentService;
    @Resource
    private UserService userService;

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

    @RequestMapping("/p/{bookId}")
    public String productDetailPage(@PathVariable("bookId") long bookId, Model model, Principal principal) {
        ResponseEntity<BookDTO> response = bookService.findBookByBookId(bookId);
        String username=(String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (response.getStatusCode() == HttpStatus.OK) {
            BookDTO book = response.getBody();
            model.addAttribute("book",book);
            model.addAttribute("username", principal.getName());
            Comment comment=new Comment();
            comment.setBookId(bookId);
            comment.setUsername(username);
            model.addAttribute("comment",comment);
            model.addAttribute("availableRatingsInts", PageConstants.availableRatingsInts);
            return "productDetailPage";
        }
        return "errorPage";
    }

    @PostMapping(value = "/p/postComment", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postComment(Comment comment, Model model, Principal principal ){

        ResponseEntity<Object> responseComment=commentService.saveComment(comment);
        if(responseComment.getStatusCode()==HttpStatus.OK)
            model.addAttribute("saveCommentMessage","Komentar sacuvan");
        if(responseComment.getStatusCode()==HttpStatus.FOUND)
            model.addAttribute("saveCommentMessage", "Ne mozete dodavati vise od jednog komentara za knjigu");
        else
            model.addAttribute("saveCommentMessage","Doslo je do greske u cuvanju komentara");

        ResponseEntity<BookDTO> responseBookNew=bookService.findBookByBookId(comment.getBookId());
        model.addAttribute("book",responseBookNew.getBody());
        model.addAttribute("username", principal.getName());
        Comment newComment=new Comment();
        newComment.setBookId(comment.getBookId());
        newComment.setUsername(comment.getUsername());
        model.addAttribute("comment",newComment);
        model.addAttribute("availableRatingsInts", PageConstants.availableRatingsInts);
        model.addAttribute("availableRatingsFloats",PageConstants.availableRatingsFloats);
        return "productDetailPage";
    }

    @GetMapping("/p/deleteComment/{bookId}/{commentId}")
    public String deleteComment(Model model, @PathVariable long bookId, @PathVariable long commentId){
        commentService.deleteComment(commentId);
        return "redirect:/p/" + bookId;
    }

    @RequestMapping("/search/{page}/{size}/{sort}/{searchType}/{searchParam}")
    private String searchResultPage(@PathVariable int page, @PathVariable int size, @PathVariable String sort, @PathVariable("searchType") String searchType,@PathVariable("searchParam") String searchParam, Model model) {

        ResponseEntity<RestPageImpl<BookDTO>> response;

        SearchType searchTypeEnum=SearchType.valueOf(searchType);
        switch(searchTypeEnum){
            case Any:
                response= bookService.findBooksPagingSearch(page,size,sort,searchParam);
                break;
            case Author:
                Long authorId=Long.parseLong(searchParam);
                response= bookService.findBooksByAuthor(authorId,page,size,sort);
                break;
            case Genre:
                Long genreId=Long.parseLong(searchParam);
                response=bookService.findBooksByGenre(genreId,page,size,sort);
                break;
            case Publisher:
                Long publisherId=Long.parseLong(searchParam);
                response=bookService.findBooksByPublisher(publisherId,page,size,sort);
                break;
            default:
                response=bookService.findBooksPaging(page,size,sort);
                break;
        }


        RestPageImpl<BookDTO> restPage = response.getBody();

        model.addAttribute("isEmpty", restPage.isEmpty());
        if (restPage.isEmpty()) {
            return "searchResultPage";
        }
        model.addAttribute("searchType",searchType.toString());
        model.addAttribute("searchParam", searchParam);
        model.addAttribute("sort", sort);
        model.addAttribute("totalNumberOfFoundElements", restPage.getTotalElements());
        model.addAttribute("isLastPage", restPage.isLast());
        model.addAttribute("isFirst", restPage.isFirst());
        model.addAttribute("totalPages",restPage.getTotalPages());
        model.addAttribute("currentPage", restPage.getNumber());
        model.addAttribute("books", restPage.getContent());
        return "searchResultPage";
    }}
