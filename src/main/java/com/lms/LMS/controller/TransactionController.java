package com.lms.LMS.controller;

import com.lms.LMS.Dto.IssueBookDto;
import com.lms.LMS.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/txn")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issue")
    public ResponseEntity <String> issueBook(@RequestBody IssueBookDto issueBookDto){

        try {
            String response = transactionService.issueBook(issueBookDto);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getInfo/{bookId}/{cardId}")
    public ResponseEntity<List<String>> getTransactionEntry(@PathVariable("bookId")Integer bookId, @PathVariable
            ("cardId")Integer cardId){

        return new ResponseEntity<List<String>>(transactionService.getTransactions(bookId,cardId),HttpStatus.ACCEPTED);
    }




}
