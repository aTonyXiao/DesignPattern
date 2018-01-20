package hw1;

/**
 * Created by TonyXiao on 1/19/18.
 */
public class SourceObserver extends Observer {

    public SourceObserver(String str){
        this.name = str;
    }

    @Override
    public void update(LibraryBook book) {
        String bookName = book.toString();

        if (bookMapState.containsKey(bookName)) {
            System.out.println(name + " OBSERVED " + bookName + " LEAVING STATE: " + bookMapState.get(bookName));
            bookMapState.replace(bookName, book.getState().toString());
        }else {
            bookMapState.put(bookName, book.getState().toString());
            System.out.println(name + " OBSERVED " + bookName + " LEAVING STATE: UNOBSERVED");
        }
    }
}
