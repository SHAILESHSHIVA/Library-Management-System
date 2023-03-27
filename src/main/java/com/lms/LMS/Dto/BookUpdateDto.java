package com.lms.LMS.Dto;

import com.lms.LMS.Enum.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class BookUpdateDto {

    int id;
    private String name;
    private Genre genre;
    private int pages;
}
