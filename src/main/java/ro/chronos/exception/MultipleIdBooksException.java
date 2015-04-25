package ro.chronos.exception;

/**
 * Cannot have multiple books with the same id.
 * <p>
 * Created by alexandrumacavei on 25.04.15.
 */
public class MultipleIdBooksException extends IllegalStateException {

	private static final long serialVersionUID = 2006817837367908347L;

	public MultipleIdBooksException() {
        super();
    }
}