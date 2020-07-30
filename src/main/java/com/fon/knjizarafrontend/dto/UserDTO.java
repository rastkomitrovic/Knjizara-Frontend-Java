package com.fon.knjizarafrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private Long userId;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Date dateOfBirth;
    private CityDTO city;
}
