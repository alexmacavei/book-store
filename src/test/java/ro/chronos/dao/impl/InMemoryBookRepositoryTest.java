package ro.chronos.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.assertj.core.groups.Properties.extractProperty;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ro.chronos.dao.IBookRepository;
import ro.chronos.exception.MultipleIdBooksException;
import ro.chronos.main.BootApplication;
import ro.chronos.model.Book;

/**
 * Test the various book repository API.
 * <p>
 * Created by alexandrumacavei on 25.04.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApplication.class)
public class InMemoryBookRepositoryTest {

    @Autowired
    IBookRepository bookRepository;

    @Mock
    Book someBook, someOtherBook;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        bookRepository.clearDatabase();
    }

    @Test
    public void testAddBookAndGetBookById() throws Exception {
        when(someBook.getBookId()).thenReturn(24);
        bookRepository.addBook(someBook);
        assertThat(bookRepository.getBookById(24)).isEqualTo(
                Optional.of(someBook));
    }

    @Test
    public void addingBookThatAlreadyExistsFailsWithMultipleIdBooksException()
            throws Exception {
        when(someBook.getBookId()).thenReturn(24);
        bookRepository.addBook(someBook);
        try {
            bookRepository.addBook(someBook);
            failBecauseExceptionWasNotThrown(MultipleIdBooksException.class);
        } catch (MultipleIdBooksException mibe) {
            assertThat(mibe).isInstanceOf(MultipleIdBooksException.class);
        }
    }

    @Test
    public void testRemoveBookById() throws Exception {
        int justSomeBookId = 24;
        when(someBook.getBookId()).thenReturn(justSomeBookId);
        bookRepository.addBook(someBook);
        bookRepository.removeBookById(justSomeBookId);
        assertThat(bookRepository.getBookById(justSomeBookId)).isEmpty();
    }

    @Test
    public void testRemoveBookByTitle() throws Exception {
        String justSomeBookTitle = "The Book of Uselessness";
        int theBookId = 11;
        when(someBook.getTitle()).thenReturn(justSomeBookTitle);
        when(someBook.getBookId()).thenReturn(theBookId);
        bookRepository.addBook(someBook);
        bookRepository.removeBookByTitle(justSomeBookTitle);
        assertThat(bookRepository.getBookById(theBookId)).isEmpty();
    }

    @Test
    public void testUpdateBook() throws Exception {
        int commonBookId = 111;

        when(someBook.getBookId()).thenReturn(commonBookId);
        when(someBook.getTitle()).thenReturn("Faust");
        when(someOtherBook.getBookId()).thenReturn(commonBookId);
        when(someOtherBook.getTitle()).thenReturn("Moby Dick");

        bookRepository.addBook(someBook);
        assertThat(bookRepository.getBookById(commonBookId)).isEqualTo(
                Optional.of(someBook));

        // book is searched & replaced by id
        bookRepository.updateBook(someOtherBook);
        assertThat(bookRepository.getBookById(commonBookId)).isEqualTo(
                Optional.of(someOtherBook));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        when(someBook.getBookId()).thenReturn(121);
        when(someOtherBook.getBookId()).thenReturn(378);
        bookRepository.addBook(someBook);
        bookRepository.addBook(someOtherBook);
        assertThat(bookRepository.getAllBooks()).hasSize(2);
        assertThat(bookRepository.getAllBooks()).contains(someBook,
                someOtherBook);
        assertThat(
                extractProperty("bookId", Integer.class).from(
                        bookRepository.getAllBooks())).contains(121, 378);
    }
}