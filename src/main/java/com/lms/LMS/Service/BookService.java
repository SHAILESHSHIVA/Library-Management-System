package com.lms.LMS.Service;

import com.lms.LMS.Dto.BookEntryDto;
import com.lms.LMS.Dto.BookResponseDto;
import com.lms.LMS.Dto.BookUpdateDto;
import com.lms.LMS.model.Author;
import com.lms.LMS.model.Book;
import com.lms.LMS.repository.AuthorRepository;
import com.lms.LMS.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public String addBook(BookEntryDto bookEntryDto){


        int authorId = bookEntryDto.getAuthorId();

        Author author = authorRepository.findById(authorId).get();

        Book book = new Book();

        book.setName(bookEntryDto.getName());
        book.setGenre(bookEntryDto.getGenre());
        book.setPages(bookEntryDto.getPages());
        book.setAuthor(author);

        List<Book> currBookList = author.getBooksWritten();
        currBookList.add(book);

        authorRepository.save(author);

        return "book saved successfully";


    }

    public BookResponseDto findBookByName(String name){

        Book book = bookRepository.findBookByName(name);

        BookResponseDto bookResponseDto = new BookResponseDto();

        bookResponseDto.setName(book.getName());
        bookResponseDto.setGenre(book.getGenre());
        bookResponseDto.setPages(book.getPages());

        return bookResponseDto;
    }

    public String deleteBook(int id){

        bookRepository.deleteById(id);

        return "book deleted successfully";
    }

    public String updateBook(BookUpdateDto bookUpdateDto){

        Book book = bookRepository.findById(bookUpdateDto.getId()).get();

        book.setName(bookUpdateDto.getName());
        book.setGenre(bookUpdateDto.getGenre());
        book.setPages(bookUpdateDto.getPages());

        bookRepository.save(book);

        return "book updated successfully";
    }





}
