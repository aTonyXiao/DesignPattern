package hw1;

/**
 * Created by TonyXiao on 1/18/18.
 */
public interface LBState {
    public void shelf(LibraryBook book);
    public void borrow(LibraryBook book);
    public void extend(LibraryBook book);
    public void returnBook(LibraryBook book);
}



