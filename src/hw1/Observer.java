package hw1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TonyXiao on 1/18/18.
 */
public abstract class Observer {

    //Using HashMap to store the Bookname and BookState
    //Faster and easier than storing the LibraryBook Object
    protected Map<String, String> bookMapState = new HashMap<String, String>();

    String name;
    public void update(LibraryBook book) {}

    @Override
    public String toString() {
        return name;
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