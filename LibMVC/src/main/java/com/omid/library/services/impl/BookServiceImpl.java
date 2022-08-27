package com.omid.library.services.impl;

import com.omid.library.models.Book;
import com.omid.library.repos.BookRepo;
import com.omid.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;

    @Override
    public List<Book> bookList() {
        return bookRepo.list();
    }

    @Override
    public void saveBook(Book book) {
        bookRepo.saveOrUpdate(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepo.delete(id);
    }

    @Override
    public Book editBook(int id) {
        return bookRepo.get(id);
    }
}
