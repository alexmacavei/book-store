package ro.chronos.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import ro.chronos.model.Book;
import ro.chronos.model.BookRental;
import ro.chronos.model.Borrower;

/**
 * This interface standardizes the contract for all rental repositories.
 * <p/>
 * Created by alexandrumacavei on 26.04.15.
 */
@Repository
public interface IRentalRepository {
	void addRental(BookRental aBookRental);

	Book getRentalById(int aBookRentalId);

	void removeRentalById(int aBookRentalId);

	void removeBookByBorrower(Borrower aBorrower);

	void updateRentalWithBook(Book aBook, BookRental aBookRental);

	List<Book> getAllBookRentals();

	List<Book> getBooksRentedByBorrower(Borrower aBorrower);
}
