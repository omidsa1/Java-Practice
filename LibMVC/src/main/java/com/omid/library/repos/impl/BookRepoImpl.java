package com.omid.library.repos.impl;

import javax.sql.DataSource;

import com.omid.library.models.Book;
import com.omid.library.repos.BookRepo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepoImpl implements BookRepo {

    private final JdbcTemplate jdbcTemplate;

    public BookRepoImpl(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource); }

    @Override
    public void saveOrUpdate(Book book){
        String sql = "INSERT INTO book (title, author_name) VALUES (?, ?)";

        jdbcTemplate.update(sql,book.getTitle(),book.getAuthor_name());
    }

    @Override
    public void delete(int bookId) {
        String sql="DELETE FROM book WHERE id=?";
        jdbcTemplate.update(sql,bookId);
    }

    @Override
    public Book get(int bookId) {
        String sql = "SELECT * FROM book WHERE id=" + bookId;
        return jdbcTemplate.query(sql, rs -> {
            if (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setAuthor_name(rs.getString("author_name"));
                return book;
            }

            return null;
        });
    }

    @Override
    public List<Book> list() {
        String sql = "SELECT * FROM book";

        List<Book> bookList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Book book = new Book();
            book.setTitle(rs.getString("title"));
            book.setAuthor_name(rs.getString("author_name"));
            return book;
        });
        return bookList;
    }
}
