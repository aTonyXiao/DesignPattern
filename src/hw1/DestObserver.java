package hw1;

/**
 * Created by TonyXiao on 1/19/18.
 */
public class DestObserver implements Observer {

    String name;
    public DestObserver(String str){
        this.name = str;
    }

    @Override
    public String toString(){
        return name;
    }

    //Print the current state
    @Override
    public void update(LibraryBook book) {
        System.out.println(name + " OBSERVED " + book.toString() + " REACHING STATE: " + book.getState().toString());
    }
}
