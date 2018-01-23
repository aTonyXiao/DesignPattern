package hw1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TonyXiao on 1/19/18.
 */
public class SourceObserver implements Observer {

    //Using HashMap to store the Bookname and BookState
    //Faster and easier than storing the LibraryBook Object
    private Map<String, String> bookMapState = new HashMap<String, String>();

    String name;

    @Override
    public String toString(){
        return name;
    }

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

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;

        if(!(obj instanceof Observer)) {
            return false;
        }

        Observer tmp = (Observer) obj;

        return this.toString().equals(tmp.toString());
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

}
