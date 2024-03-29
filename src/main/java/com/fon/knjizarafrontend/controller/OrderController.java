package com.fon.knjizarafrontend.controller;

import com.fon.knjizarafrontend.constants.RestPageImpl;
import com.fon.knjizarafrontend.dto.OrderDTO;
import com.fon.knjizarafrontend.request.OrderRequest;
import com.fon.knjizarafrontend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/basket")
    public String basketPage() {
        return "basket";
    }

    @PostMapping(path = "/processOrder")
    public ResponseEntity<Object> processOrder(@RequestBody OrderRequest orderRequest , Model model, Principal principal){
        orderRequest.setUsername(principal.getName());

        ResponseEntity<Object> responseEntity=orderService.saveOrder(orderRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/orders/{page}/{size}/{sort}")
    public String ordersPage(Model model, Principal principal, @PathVariable int page, @PathVariable int size, @PathVariable String sort){
        ResponseEntity<RestPageImpl<OrderDTO>> responseEntity;
        Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if(roles.stream().anyMatch(it -> it.getAuthority().equals("ADMIN")))
            responseEntity = orderService.findOrdersPaging(page,size,sort);
        else
            responseEntity = orderService.findOrdersByUsername(principal.getName(),page,size,sort);
        RestPageImpl<OrderDTO> restPage=responseEntity.getBody();
        model.addAttribute("isEmpty", restPage.isEmpty());
        if(restPage.isEmpty()){
            return "ordersPage";
        }
        model.addAttribute("sort", sort);
        model.addAttribute("totalNumberOfFoundElements",restPage.getTotalElements());
        model.addAttribute("isLastPage",restPage.isLast());
        model.addAttribute("isFirst",restPage.isFirst());
        model.addAttribute("totalPages",restPage.getTotalPages());
        model.addAttribute("currentPage",restPage.getNumber());
        model.addAttribute("orders",restPage.getContent());
        return "ordersPage";
    }
}
