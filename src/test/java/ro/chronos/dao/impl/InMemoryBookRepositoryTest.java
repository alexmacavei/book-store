package ro.chronos.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.chronos.dao.IBookRepository;
import ro.chronos.main.BootApplication;
import ro.chronos.model.Book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    Book someBook;

    @Before
    public void setUp() throws Exception {
        someBook = mock(Book.class);
    }

    @Test
    public void testAddBookAndGetBookById() throws Exception {
        when(someBook.getBookId()).thenReturn(24);
        bookRepository.addBook(someBook);
        assertThat(bookRepository.getBookById(24)).isEqualTo(someBook);
    }

    @Test
    public void testRemoveBookById() throws Exception {

    }

    @Test
    public void testRemoveBookByTitle() throws Exception {

    }

    @Test
    public void testUpdateBook() throws Exception {

    }

    @Test
    public void testGetAllBooks() throws Exception {

    }
}