package hw1;

/**
 * Created by TonyXiao on 1/19/18.
 */
public class DestObserver extends Observer {

    public DestObserver(String str){
        this.name = str;
    }

    @Override
    public void update(LibraryBook book) {
        System.out.println(name + " OBSERVED " + book.toString() + " REACHING STATE: " + book.getState().toString());
    }
}
