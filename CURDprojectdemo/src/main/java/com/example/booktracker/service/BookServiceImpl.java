package com.example.booktracker.service;

import com.example.booktracker.model.Book;
import com.example.booktracker.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Optional<Book> existing = repository.findById(id);
        if (existing.isPresent()) {
            Book b = existing.get();
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            b.setIsbn(book.getIsbn());
            return repository.save(b);
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
