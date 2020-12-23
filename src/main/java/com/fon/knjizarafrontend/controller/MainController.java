package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.dto.AuthorDTO;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.dto.GenreDTO;
import com.fon.knjizarafrontend.dto.UserDTO;
import com.fon.knjizarafrontend.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.xml.ws.Response;
import java.security.Principal;
import java.util.Arrays;
import java.util.LinkedList;

@Controller
public class MainController {

    @Resource
    private BookService bookService;

    @Resource
    private GenreService genreService;

    @Resource
    private UserService userService;

    @Resource
    private AuthorService authorService;

    @Resource
    private BasketService basketService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/mainPage")
    public String helloPage(Model model, Principal principal) {
        ResponseEntity<BookDTO[]> bookDtoResponse = bookService.getAllBooksBestReviews();
        ResponseEntity<GenreDTO[]> genresDtoResponse = genreService.getAllGenresNoPaging();

        ResponseEntity<UserDTO> resUser=userService.findUserByUsername("rastko");
        UserDTO user=resUser.getBody();
        user.setPassword(passwordEncoder.encode("rastko"));
        userService.updateUser(user);

        ResponseEntity<AuthorDTO[]> authorsResponse=authorService.findAllAuthorsNoPaging();
        if (bookDtoResponse.getStatusCode().equals(HttpStatus.OK) && genresDtoResponse.getStatusCode().equals(HttpStatus.OK) && authorsResponse.getStatusCode().equals(HttpStatus.OK)) {
            model.addAttribute("books",
                    bookDtoResponse.getBody() == null ? new LinkedList<>() : Arrays.asList(bookDtoResponse.getBody()));
            model.addAttribute("genres", genresDtoResponse.getBody() == null ? new LinkedList<>() : Arrays.asList(genresDtoResponse.getBody()));
            model.addAttribute("authors", authorsResponse.getBody() == null ? new LinkedList<>() : Arrays.asList(authorsResponse.getBody()));
        }

        return "index";
    }

    @RequestMapping(value = "/basket")
    public String basketPage() {
        return "basket";
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