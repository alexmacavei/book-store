package ro.chronos.dao;

import org.springframework.stereotype.Repository;

import ro.chronos.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * This interface standardizes the contract for all book repositories.
 * <p/>
 * Created by alexandrumacavei on 25.04.15.
 */
@Repository
public interface IBookRepository {
    void addBook(Book aBook);

    Optional<Book> getBookById(int aBookId);

    void removeBookById(int aBookId);

    void removeBookByTitle(String aBookTitle);

    void updateBook(Book book);

    List<Book> getAllBooks();
    
    void clearDatabase();
}
