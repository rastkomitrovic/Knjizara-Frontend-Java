package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class ProductDetailPageController {

    @Resource
    private BookService bookService;

    @RequestMapping("/p/{bookId}")
    private String productDetailPage(@PathVariable("bookId") long bookId, Model model) {
        ResponseEntity<BookDTO> response = bookService.findBookByBookId(bookId);
        if (response.getStatusCode() == HttpStatus.OK) {
            BookDTO book = response.getBody();
            model.addAttribute(book);
            return "productDetailPage";
        }
        return "productNotFound";
    }
}
