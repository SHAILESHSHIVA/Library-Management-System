package com.lms.LMS.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorEntryDto {

    private String name;

    private int age;

    private String country;

    private double rating;
}
