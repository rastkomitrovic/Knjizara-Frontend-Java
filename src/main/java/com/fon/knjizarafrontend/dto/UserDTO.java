package com.fon.knjizarafrontend.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fon.knjizarafrontend.auth.CustomAuthority;
import com.fon.knjizarafrontend.auth.CustomUserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("address")
    private String address;
    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;
    @JsonProperty("city")
    private CityDTO city;
    @JsonProperty("role")
    private String role;

    public CustomUserDetails toCustomUserDetails() {
        return new CustomUserDetails(username, password, name, lastName, email, phone, address, dateOfBirth, city, new CustomAuthority(role));
    }
}
