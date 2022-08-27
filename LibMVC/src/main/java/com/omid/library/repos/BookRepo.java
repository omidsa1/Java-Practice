package com.omid.library.repos;

import com.omid.library.models.Book;

import java.util.List;

public interface BookRepo {
    public void saveOrUpdate(Book book);

    public void delete(int bookId);

    public Book get(int bookId);

    public List<Book> list();
}
