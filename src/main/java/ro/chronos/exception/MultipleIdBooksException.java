package ro.chronos.exception;

/**
 * Cannot have multiple books with the same id.
 * <p>
 * Created by alexandrumacavei on 25.04.15.
 */
public class MultipleIdBooksException extends IllegalStateException {
    public MultipleIdBooksException() {
        super();
    }
}