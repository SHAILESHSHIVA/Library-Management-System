package com.lms.LMS.controller;

import com.lms.LMS.Dto.BookEntryDto;
import com.lms.LMS.Dto.BookResponseDto;
import com.lms.LMS.Dto.BookUpdateDto;
import com.lms.LMS.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody BookEntryDto bookEntryDto){

        String response = bookService.addBook(bookEntryDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }

    @GetMapping("/getBook/{name}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable ("name") String name){

        BookResponseDto bookResponseDto = bookService.findBookByName(name);

        return new ResponseEntity<>(bookResponseDto,HttpStatus.FOUND);

    }

    @PutMapping("/update")
    public ResponseEntity<String> updateBook(@RequestBody BookUpdateDto bookUpdateDto){

        String response = bookService.updateBook(bookUpdateDto);

        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id){

        String response = bookService.deleteBook(id);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
