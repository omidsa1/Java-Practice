package com.omid.library.services;


import com.omid.library.models.Book;

import java.util.List;


public interface BookService {


    public List<Book> bookList();

    public void saveBook(Book model);

    public void deleteBook(Integer id);

    public Book editBook(int model);


}
