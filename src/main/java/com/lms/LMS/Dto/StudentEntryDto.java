package com.lms.LMS.Dto;



import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentEntryDto {

    private String name;
    private String email;

    @NotNull
    private String mobNo;

    private int age;

    private String address;


}
