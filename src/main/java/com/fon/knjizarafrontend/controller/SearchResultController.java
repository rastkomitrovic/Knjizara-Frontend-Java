package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.constants.SearchType;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.LinkedList;

@Controller
public class SearchResultController {
    @Resource
    private BookService bookService;


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
        model.addAttribute("books", restPage.getContent() != null ? restPage.getContent() : new LinkedList<>());
        return "searchResultPage";
    }
}
