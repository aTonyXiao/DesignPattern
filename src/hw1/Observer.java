package hw1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TonyXiao on 1/18/18.
 */
public abstract class Observer {

    protected Map<String, String> bookMapState = new HashMap<String, String>();

    String name;
    public void update(LibraryBook book) {}

    @Override
    public String toString() {
        return name;
    }
}