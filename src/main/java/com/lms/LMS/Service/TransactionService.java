package com.lms.LMS.Service;

import com.lms.LMS.Dto.IssueBookDto;
import com.lms.LMS.Enum.CardStatus;
import com.lms.LMS.Enum.TransactionStatus;
import com.lms.LMS.model.Book;
import com.lms.LMS.model.Card;
import com.lms.LMS.model.Transaction;
import com.lms.LMS.repository.BookRepository;
import com.lms.LMS.repository.CardRepository;
import com.lms.LMS.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private TransactionRepository transactionRepository;


    public String issueBook(IssueBookDto issueBookDto) throws Exception{

        Book book = bookRepository.findById(issueBookDto.getBookId()).get();
        Card card = cardRepository.findById(issueBookDto.getCardId()).get();

        Transaction transaction = new Transaction();

        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        if(book==null || book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book already issued or not available");
        }

        if(card==null || (card.getCardStatus()!= CardStatus.ACTIVATED)){

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card status is not active or not issued");

        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        book.setIssued(true);
        List<Transaction> listOfTransaction = book.getListOfTransactions();
        listOfTransaction.add(transaction);
        book.setListOfTransactions(listOfTransaction);

        List<Book> issuedBooksForCard = card.getBookedIssued();
        issuedBooksForCard.add(book);
        card.setBookedIssued(issuedBooksForCard);

        List<Transaction> transactionsListForCard = card.getListOfTransaction();
        transactionsListForCard.add(transaction);
        card.setListOfTransaction(transactionsListForCard);

        cardRepository.save(card);

        return "Book issued successfully";

    }

    public List<String> getTransactions(int bookId,int cardId){

        List<Transaction> transactionsList = transactionRepository.getTransactionsForBookAndCard(bookId,cardId);
        List<String> listOfTransaction = new ArrayList<>();

        for(Transaction transaction:transactionsList)
        {
            listOfTransaction.add(transaction.getTransactionId());
        }

//        String transactionId = transactionsList.get(0).getTransactionId();

        return listOfTransaction;
    }
}
