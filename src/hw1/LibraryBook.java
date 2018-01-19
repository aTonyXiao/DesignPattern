package hw1;

/**
 * Created by TonyXiao on 1/18/18.
 */
public class LibraryBook {
    private LBState state;

    public LibraryBook(){
        this.state = null;
    }

    public void setState(LBState state){
        this.state = state;
    }

    public LBState getState(){
        return state;
    }

    public void borrow() throws NotAllowedException {
        state.borrow(this);
    }

    public void returnBook() throws NotAllowedException {
        state.returnBook(this);
    }
    public void shelf() throws NotAllowedException {
        state.shelf(this);
    }

    public void extend() throws NotAllowedException {
        state.extend(this);
    }

}


class NotAllowedException extends Exception {
    public NotAllowedException(String string) {
        super("Can't use " + string + " state");
    }
    public NotAllowedException(String string, Throwable throwable) {
        super("Can't use " + string + " state");
    }
}


class OnLoan implements LBState {

    //MARK: OnLoan Singleton
    private static OnLoan instance = null;
    private OnLoan() {
        System.out.println("OnLoan Instance Created");
    }
    public static OnLoan getInst() {
        if(instance == null)
            instance = new OnLoan();
        return instance;
    }

    @Override
    public void shelf(LibraryBook book) throws NotAllowedException {
        throw new NotAllowedException(("shelf in OnLoan"));
    }

    @Override
    public void borrow(LibraryBook book) throws NotAllowedException {
        throw new NotAllowedException("borrow in OnLoan");
    }

    @Override
    public void extend(LibraryBook book) {
        System.out.println("Leaving State OnLoan for State OnLoan");
        book.setState(this);
    }

    @Override
    public void returnBook(LibraryBook book) {
        System.out.println("Leaving State OnLoan for State Returned");
        book.setState(this);
    }

    public String toString(){
        return "OnLoan";
    }

}

class Shelved implements LBState {

    //MARK: Shelved Singleton
    private static Shelved instance = null;
    private Shelved() {
        System.out.println("OnLoan Instance Created");
    }
    public static Shelved getInst() {
        if(instance == null)
            instance = new Shelved();
        return instance;
    }

    @Override
    public void shelf(LibraryBook book) throws NotAllowedException {
        throw new NotAllowedException("shelf in Shelved");
    }


    @Override
    public void borrow(LibraryBook book) {
        System.out.println("Leaving State Shelved for State OnLoan");
        book.setState(this);
    }

    @Override
    public void extend(LibraryBook book) throws NotAllowedException {
        throw new NotAllowedException("extend in Shelved");
    }

    @Override
    public void returnBook(LibraryBook book) throws NotAllowedException {
        throw new NotAllowedException("shelf in Shelved");
    }

    public String toString(){
        return "Shelved";
    }
}

class Returned implements LBState {

    //MARK: Returned Singleton
    private static Returned instance = null;
    private Returned() {
        System.out.println("OnLoan Instance Created");
    }
    public static Returned getInst() {
        if(instance == null)
            instance = new Returned();
        return instance;
    }

    @Override
    public void shelf(LibraryBook book) {
        System.out.println("Leaving State Returned for State Shelved");
        book.setState(this);
    }

    @Override
    public void borrow(LibraryBook book) throws NotAllowedException {
        throw new NotAllowedException("shelf in Shelved");
    }

    @Override
    public void extend(LibraryBook book) throws NotAllowedException {
        throw new NotAllowedException("shelf in Shelved");
    }

    @Override
    public void returnBook(LibraryBook book) throws NotAllowedException {
        throw new NotAllowedException("shelf in Shelved");
    }

    public String toString(){
        return "Returned";
    }
}