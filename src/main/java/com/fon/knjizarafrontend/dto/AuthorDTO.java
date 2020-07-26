package com.fon.knjizarafrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Long authorId;
    private Date dateOfBirth;
    private String firstName;
    private String middleName;
    private String lastName;
    private String description;
    private List<BookDTO> books;
}
