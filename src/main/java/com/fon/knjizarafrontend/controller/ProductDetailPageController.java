package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.constants.PageConstants;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.fc.Comment;
import com.fon.knjizarafrontend.service.BookService;
import com.fon.knjizarafrontend.service.CommentService;
import com.fon.knjizarafrontend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class ProductDetailPageController {

    @Resource
    private BookService bookService;
    @Resource
    private CommentService commentService;
    @Resource
    private UserService userService;


    @RequestMapping("/p/{bookId}")
    public String productDetailPage(@PathVariable("bookId") long bookId, Model model) {
        ResponseEntity<BookDTO> response = bookService.findBookByBookId(bookId);
        String username=(String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (response.getStatusCode() == HttpStatus.OK) {
            BookDTO book = response.getBody();
            model.addAttribute("book",book);
            Comment comment=new Comment();
            comment.setCommentId(-1L);
            comment.setBookId(bookId);
            comment.setUsername(username);
            model.addAttribute("comment",comment);
            model.addAttribute("availableRatingsInts", PageConstants.availableRatingsInts);
            return "productDetailPage";
        }
        return "productNotFound";
    }

    @PostMapping(value = "/p/postComment", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postComment(Comment comment, Model model){

        ResponseEntity<Object> responseComment=commentService.saveComment(comment);
        if(responseComment.getStatusCode()==HttpStatus.OK)
            model.addAttribute("saveCommentMessage","Komentar sacuvan");
        if(responseComment.getStatusCode()==HttpStatus.FOUND)
            model.addAttribute("saveCommentMessage", "Ne mozete dodavati vise od jednog komentara za knjigu");
        else
            model.addAttribute("saveCommentMessage","Doslo je do greske u cuvanju komentara");

        ResponseEntity<BookDTO> responseBookNew=bookService.findBookByBookId(comment.getBookId());
        model.addAttribute("book",responseBookNew.getBody());
        Comment newComment=new Comment();
        newComment.setCommentId(-1L);
        newComment.setBookId(comment.getBookId());
        newComment.setUsername(comment.getUsername());
        model.addAttribute("comment",newComment);
        model.addAttribute("availableRatingsInts", PageConstants.availableRatingsInts);
        model.addAttribute("availableRatingsFloats",PageConstants.availableRatingsFloats);
        return "productDetailPage";
    }
}
