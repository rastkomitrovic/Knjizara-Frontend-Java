package com.fon.knjizarafrontend;

import com.fon.knjizarafrontend.dto.BasketDTO;
import com.fon.knjizarafrontend.dto.BookDTO;
import com.fon.knjizarafrontend.dto.UserDTO;
import com.fon.knjizarafrontend.service.BasketService;
import com.fon.knjizarafrontend.service.BookService;
import com.fon.knjizarafrontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BasketService basketService;

    @GetMapping("/hello")
    public String helloPage(Model model, Principal principal) {
        ResponseEntity<BookDTO[]> bookDtoResponse=bookService.getAllBooksBestReviews();
        ResponseEntity<UserDTO> userDtoResponse=userService.findUserByUsername(principal.getName());
        ResponseEntity<BasketDTO> basketDTOResponseEntity=basketService.findBasketByUserUsername(principal.getName());

        if(bookDtoResponse.getStatusCode().equals(HttpStatus.OK) && userDtoResponse.getStatusCode().equals(HttpStatus.OK)) {
            model.addAttribute("bestReviewBooks",
                    bookDtoResponse.getBody()==null ? new LinkedList<>() : Arrays.asList(bookDtoResponse.getBody()));
            model.addAttribute("user",userDtoResponse.getBody());
            model.addAttribute("basket",basketDTOResponseEntity.getBody());
        }

        return "hello";
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