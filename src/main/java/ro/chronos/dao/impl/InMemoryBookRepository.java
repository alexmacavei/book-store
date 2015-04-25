package ro.chronos.dao.impl;

import org.springframework.stereotype.Component;
import ro.chronos.dao.IBookRepository;
import ro.chronos.exception.MultipleIdBooksException;
import ro.chronos.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.stream.Collector;

/**
 * An in-memory representation of a book repository.
 * <p>
 * Created by alexandrumacavei on 25.04.15.
 */
@Component("in_memory")
public class InMemoryBookRepository implements IBookRepository {

    private List<Book> bookRepository = new ArrayList<>();

    /**
     * This API inserts a new book in the database.
     *
     * @param aBook item to add
     */
    public void addBook(final Book aBook) {
        bookRepository.add(aBook);
    }

    /**
     * Retrieves a book from the database with the corresponding bookId.
     *
     * @param aBookId book to search for
     * @return found book or null for none matching
     */
    public Book getBookById(final int aBookId) {
        return bookRepository.stream().filter(b -> b.getBookId() == aBookId).collect(singleBookCollector());
    }

    /**
     * Removes a book from the database, found by bookId.
     *
     * @param aBookId book to delete
     */
    public void removeBookById(int aBookId) {
        bookRepository.stream().filter(book -> book.getBookId() == aBookId).forEach(bookRepository::remove);
    }

    /**
     * Removes a book from the database, found by book title.
     *
     * @param aBookTitle book to delete
     */
    public void removeBookByTitle(String aBookTitle) {
        bookRepository.stream().filter(book -> Objects.equals(book.getTitle(), aBookTitle)).forEach(bookRepository::remove);
    }

    /**
     * This API replaces the contents of Book objects in database, matching with the bookId in the passed parameter.
     *
     * @param aBook item to update with
     */
    public void updateBook(Book aBook) {
        ListIterator<Book> repoIterator = bookRepository.listIterator();

        while (repoIterator.hasNext()) {
            if (aBook.getBookId() == repoIterator.next().getBookId()) {
                repoIterator.set(aBook);
            }
        }
    }

    /**
     * Retrieves all books from database.
     *
     * @return list of books
     */
    public List<Book> getAllBooks() {
        return bookRepository;
    }

    private static <T> Collector<T, List<T>, T> singleBookCollector() {
        return Collector.of(
                ArrayList::new,
                List::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                list -> {
                    if (list.size() > 1) {
                        throw new MultipleIdBooksException();
                    }
                    return list.get(0);
                }
        );
    }
}
