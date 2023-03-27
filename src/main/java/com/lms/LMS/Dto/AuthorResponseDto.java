package com.lms.LMS.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorResponseDto {

    private String name;
    private int age;
    private double rating;
    private String country;

}
