package ro.chronos.model;

import java.math.BigDecimal;

/**
 * Book model class, required by business methods.
 * <p/>
 * Created by alexandrumacavei on 25.04.15.
 */
public class Book {

    public int bookId;
    public String title;
    public String authorName;
    public BigDecimal price;
    public boolean withPictures;

    public Book(int bookId, String title, String authorName, BigDecimal price, boolean withPictures) {
        this.title = title;
        this.authorName = authorName;
        this.price = price;
        this.withPictures = withPictures;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isWithPictures() {
        return withPictures;
    }
}
