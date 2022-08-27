package com.omid.library.controllers;


import com.omid.library.models.Book;
import com.omid.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;





@Controller("/book")
public class BookController {

@Autowired
BookService bookService;


    @RequestMapping(value = "/list")
    public ModelAndView bookList(ModelAndView model){
        List<Book> bookList = bookService.bookList();
        model.addObject("bookList",bookList);
        model.setViewName("root");
        return model;    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView newBook(ModelAndView model) {
        Book newBook = new Book();
        model.addObject("book", newBook);
        model.setViewName("BookForm");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteBook(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter("id"));
        bookService.deleteBook(bookId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editBook(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.editBook(bookId);
        ModelAndView model = new ModelAndView("BookForm");
        model.addObject("book", book);
        return model;
    }

}

















