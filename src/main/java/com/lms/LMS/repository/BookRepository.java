package com.lms.LMS.repository;

import com.lms.LMS.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookByName(String name);

}
