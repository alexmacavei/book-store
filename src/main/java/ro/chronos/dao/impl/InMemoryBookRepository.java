package ro.chronos.dao.impl;

import org.springframework.stereotype.Component;

import ro.chronos.dao.IBookRepository;
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
		bookRepository.add(aBook);
	}

	/**
	 * Retrieves a book from the database with the corresponding bookId.
	 *
	 * @param aBookId
	 *            book to search for
	 * @return found book or null for none matching
	 */
	public Book getBookById(final int aBookId) {
		Optional<Book> maybeABook = bookRepository.stream().filter(b -> b.getBookId() == aBookId)
				.findFirst();
		if (maybeABook.isPresent()) {
			return maybeABook.get();
		}
		else {
			return null;
		}
	}

	/**
	 * Removes a book from the database, found by bookId.
	 *
	 * @param aBookId
	 *            book to delete
	 */
	public void removeBookById(int aBookId) {
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
	public void removeBookByTitle(String aBookTitle) {
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
}
