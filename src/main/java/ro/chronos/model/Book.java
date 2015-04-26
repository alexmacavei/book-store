package ro.chronos.model;

import java.math.BigDecimal;

/**
 * Book model class, required by business methods.
 * <p/>
 * Created by alexandrumacavei on 25.04.15.
 */
public class Book {

    private int bookId;
    private String title;
    private String authorName;
    private BigDecimal price;
    private boolean withPictures;

    public Book(int aBookId, String aTitle, String anAuthorName,
            BigDecimal aPrice, boolean aWithPictures) {
        this.bookId = aBookId;
        this.title = aTitle;
        this.authorName = anAuthorName;
        this.price = aPrice;
        this.withPictures = aWithPictures;
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
