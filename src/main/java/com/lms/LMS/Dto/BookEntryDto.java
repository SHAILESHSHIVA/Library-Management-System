package com.lms.LMS.Dto;

import com.lms.LMS.Enum.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookEntryDto {

    private String name;

    private int pages;

    private Genre genre;

    private int authorId;


}
