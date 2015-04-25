package ro.chronos.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ro.chronos.dao.IBookRepository;
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
    Book someBook;

    @Before
    public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddBookAndGetBookById() throws Exception {
        when(someBook.getBookId()).thenReturn(24);
        bookRepository.addBook(someBook);
        assertThat(bookRepository.getBookById(24)).isEqualTo(someBook);
    }

    @Test
    public void testRemoveBookById() throws Exception {
    	when(someBook.getBookId()).thenReturn(24);
    	bookRepository.addBook(someBook);
    	bookRepository.removeBookById(someBook.getBookId());
    	assertThat(bookRepository.getBookById(24)).isNull();
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