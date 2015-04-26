package ro.chronos.model;

import java.util.List;

public class BookRental {
	private int rentalId;
	private Borrower borrower;
	private List<Book> borrowedBooks;

	public BookRental(int aRentalId, Borrower aBorrower, List<Book> aBorrowedBooks) {
		this.rentalId = aRentalId;
		this.borrower = aBorrower;
		this.borrowedBooks = aBorrowedBooks;
	}

	public int getRentalId() {
		return rentalId;
	}
	
	public Borrower getBorrower() {
		return borrower;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
}
