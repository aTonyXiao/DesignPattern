package hw1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TonyXiao on 1/18/18.
 */
public interface Observer {

    public void update(LibraryBook book);
    public String toString();
    public boolean equals(Object obj);
    public int hashCode();
}