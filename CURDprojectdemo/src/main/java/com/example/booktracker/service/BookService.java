package com.example.booktracker.service;

import com.example.booktracker.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}

