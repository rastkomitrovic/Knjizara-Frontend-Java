package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.service.BasketService;
import com.fon.knjizarafrontend.service.BookService;
import com.fon.knjizarafrontend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Arrays;
import java.util.LinkedList;

@Controller
public class MainController {

    @Resource
    private BookService bookService;

    @Resource
    private UserService userService;

    @Resource
    private BasketService basketService;

    @RequestMapping(value = "/mainPage")
    public String helloPage(Model model, Principal principal) {
        ResponseEntity<BookDTO[]> bookDtoResponse = bookService.getAllBooksBestReviews();
        if (bookDtoResponse.getStatusCode().equals(HttpStatus.OK)) {
            model.addAttribute("books",
                    bookDtoResponse.getBody() == null ? new LinkedList<>() : Arrays.asList(bookDtoResponse.getBody()));
        }

        return "index";
    }

}


/*
String response= restTemplate.getForObject("http://localhost:9090/api/v0/countries", String.class );


        System.out.println(response);

        try {
            List<CountryDTO> list = new ObjectMapper().readValue(response, new TypeReference<>() {
            });
            for(CountryDTO c:list){
                System.out.println(c.getCountryName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }



 CountryDTO countryDTO=new CountryDTO(-1L,"Greece","GR","Land on the south of the balkans");
        ResponseEntity<Object> responseForPost=restTemplate.postForEntity("http://localhost:9090/api/v0/countries",countryDTO,Object.class);

        System.out.println("Response for POST:"+responseForPost.getStatusCode().toString());





        ResponseEntity<CountryDTO[]> responseEntity=restTemplate.getForEntity("http://localhost:9090/api/v0/countries",CountryDTO[].class);

        System.out.println("Response for GET:"+responseEntity.getStatusCode().toString());

        List<CountryDTO> list= Arrays.asList(responseEntity.getBody());

        for(CountryDTO c:list){
            System.out.println("AAAA");
            System.out.println(c.getCountryName());
        }
 */