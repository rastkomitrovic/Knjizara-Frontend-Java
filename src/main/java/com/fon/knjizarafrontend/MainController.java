package com.fon.knjizarafrontend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fon.knjizarafrontend.dto.CountryDTO;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/hello")
    public String helloPage(Model model){


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