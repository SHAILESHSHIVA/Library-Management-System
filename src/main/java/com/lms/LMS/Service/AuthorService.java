package com.lms.LMS.Service;

import com.lms.LMS.Dto.AuthorEntryDto;
import com.lms.LMS.Dto.AuthorResponseDto;
import com.lms.LMS.model.Author;
import com.lms.LMS.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {


    @Autowired
    private AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){

        Author author = new Author();
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setRating(authorEntryDto.getRating());
        author.setCountry(authorEntryDto.getCountry());

        authorRepository.save(author);
        return "Author added successfully";
   }

   public AuthorResponseDto getAuthor(int id){

        Author author = authorRepository.findById(id).get();

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();

        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setRating(author.getRating());
        authorResponseDto.setCountry(author.getCountry());

        return authorResponseDto;

   }



}
