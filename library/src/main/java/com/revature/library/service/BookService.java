package com.revature.library.service;

import com.revature.library.model.Book;
import com.revature.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * BookService - TODO: Implement using constructor injection
 */
@Service
public class BookService {

    // TODO: Declare a final BookRepository field
    // private final BookRepository bookRepository;

    private final BookRepository bookRepository;


    // TODO: Create constructor that accepts BookRepository
     public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
     }

    public List<Book> getAllBooks() {
         return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        // TODO: Find book by ID

        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
         this.bookRepository.save(book);
        return book;
    }

    public Book checkoutBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is already checked out");
        }

        book.setAvailable(false);
        return bookRepository.save(book);
    }

    public Book returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setAvailable(true);
        return bookRepository.save(book);
    }
}
