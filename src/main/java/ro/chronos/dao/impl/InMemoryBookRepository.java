package ro.chronos.dao.impl;

import org.springframework.stereotype.Component;

import ro.chronos.dao.IBookRepository;
import ro.chronos.exception.MultipleIdBooksException;
import ro.chronos.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
	 * @param aBook
	 *            item to add
	 */
	public void addBook(final Book aBook) {
		if (getBookById(aBook.getBookId()).isPresent()) {
			throw new MultipleIdBooksException();
		} else {
			bookRepository.add(aBook);
		}
	}

	/**
	 * Retrieves a book from the database with the corresponding bookId.
	 *
	 * @param aBookId
	 *            book to search for
	 * @return returns Optional<Book> for the searched book
	 */
	public Optional<Book> getBookById(final int aBookId) {
		return bookRepository.stream().filter(b -> b.getBookId() == aBookId)
				.findFirst();
	}

	/**
	 * Removes a book from the database, found by bookId.
	 *
	 * @param aBookId
	 *            book to delete
	 */
	public void removeBookById(final int aBookId) {
		bookRepository = bookRepository.stream()
				.filter(book -> book.getBookId() != aBookId)
				.collect(Collectors.toList());
	}

	/**
	 * Removes a book from the database, found by book title.
	 *
	 * @param aBookTitle
	 *            book to delete
	 */
	public void removeBookByTitle(final String aBookTitle) {
		bookRepository = bookRepository.stream()
				.filter(book -> !Objects.equals(book.getTitle(), aBookTitle))
				.collect(Collectors.toList());
	}

	/**
	 * This API replaces the contents of Book objects in database, matching with
	 * the bookId in the passed parameter.
	 *
	 * @param aBook
	 *            item to update with
	 */
	public void updateBook(final Book aBook) {
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
	
	/**
	 * CAUTION! This one empties the database!
	 */
	public void clearDatabase() {
		bookRepository = new ArrayList<>();
	}
}
