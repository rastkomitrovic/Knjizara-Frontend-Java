package com.fon.knjizarafrontend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    @JsonProperty("authorId")
    private Long authorId;
    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("books")
    private List<BookDTO> books;

    @Override
    public String toString() {
        if(middleName!=null && middleName.length()>=1)
            return firstName+" "+middleName+" "+lastName;
        return firstName+" "+lastName;
    }
}
