package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.constants.PageConstants;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.dto.CommentDTO;
import com.fon.knjizarafrontend.dto.UserDTO;
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
import java.util.List;

@Controller
public class ProductDetailPageController {

    @Resource
    private BookService bookService;
    @Resource
    private CommentService commentService;
    @Resource
    private UserService userService;

    @RequestMapping("/p/{bookId}")
    private String productDetailPage(@PathVariable("bookId") long bookId, Model model) {
        ResponseEntity<BookDTO> response = bookService.findBookByBookId(bookId);
        String username=(String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (response.getStatusCode() == HttpStatus.OK) {
            BookDTO book = response.getBody();
            model.addAttribute("book",book);
            Comment comment=new Comment();
            comment.setBookId(bookId);
            comment.setUsername(username);
            model.addAttribute("comment",comment);
            model.addAttribute("availableRatingsInts", PageConstants.availableRatingsInts);
            return "productDetailPage";
        }
        return "productNotFound";
    }

    @PostMapping(value = "/p/postComment", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    private String postComment(Comment comment,Model model){
        ResponseEntity<UserDTO> responseUser=userService.findUserByUsername(comment.getUsername());
        UserDTO user=responseUser.getBody();
        ResponseEntity<BookDTO> responseBook=bookService.findBookByBookId(comment.getBookId());
        BookDTO book=responseBook.getBody();
        CommentDTO commentDTO=new CommentDTO();
        commentDTO.setBook(book);
        commentDTO.setText(comment.getText());
        commentDTO.setUser(user);
        float rating=comment.getRating();
        commentDTO.setRating(rating);
        commentDTO.setCommentId((long) -1);
        ResponseEntity<Object> responseComment=commentService.saveComment(commentDTO);
        if(responseComment.getStatusCode()==HttpStatus.OK)
            model.addAttribute("saveCommentMessage","Komentar sacuvan");
        else
            model.addAttribute("saveCommentMessage","Doslo je do greske u cuvanju komentara");

        ResponseEntity<BookDTO> responseBookNew=bookService.findBookByBookId(comment.getBookId());
        model.addAttribute("book",responseBookNew.getBody());
        Comment newComment=new Comment();
        newComment.setBookId(book.getBookId());
        newComment.setUsername(user.getUsername());
        model.addAttribute("comment",newComment);
        model.addAttribute("availableRatingsInts", PageConstants.availableRatingsInts);
        model.addAttribute("availableRatingsFloats",PageConstants.availableRatingsFloats);
        return "productDetailPage";
    }
}
