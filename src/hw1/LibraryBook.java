package hw1;

/**
 * Created by TonyXiao on 1/18/18.
 */
public class LibraryBook {
    private LBState state;

    public LibraryBook(String string){
        this.state = Shelved.getInst();
    }

    public void setState(LBState state){
        this.state = state;
    }

    public LBState getState(){
        return state;
    }

    public void borrow() {
        state.borrow(this);
    }

    public void returnBook() {
        state.returnBook(this);
    }
    public void shelf() {
        state.shelf(this);
    }

    public void extend() {
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

    
    public void shelf(LibraryBook book) {
        try {
            throw new NotAllowedException(("shelf in OnLoan"));
        } catch (NotAllowedException e) {
            System.out.println(e.toString());
        }
    }

    
    public void borrow(LibraryBook book) {
        try {
            throw new NotAllowedException("borrow in OnLoan");
        } catch (NotAllowedException e) {
            System.out.println(e.toString());
        }
    }

    
    public void extend(LibraryBook book) {
        System.out.println("Leaving State OnLoan for State OnLoan");
        book.setState(this);
    }

    
    public void returnBook(LibraryBook book) {
        System.out.println("Leaving State OnLoan for State Returned");
        book.setState(Returned.getInst());
    }

    public String toString(){
        return "OnLoan";
    }

}

class Shelved implements LBState {

    //MARK: Shelved Singleton
    private static Shelved instance = null;
    private Shelved() {
//        System.out.println("OnLoan Instance Created");
    }
    public static Shelved getInst() {
        if(instance == null)
            instance = new Shelved();
        return instance;
    }

    public void shelf(LibraryBook book) {
        try {
            throw new NotAllowedException("shelf in Shelved");
        } catch (NotAllowedException e) {
            System.out.println(e.toString());
        }
    }


    public void borrow(LibraryBook book) {
        System.out.println("Leaving State Sheleved for State OnLoan");
        book.setState(OnLoan.getInst());
    }

    
    public void extend(LibraryBook book) {
        try {
            throw new NotAllowedException("extend in Shelved");
        } catch (NotAllowedException e) {
            System.out.println(e.toString());
        }
    }

    
    public void returnBook(LibraryBook book) {
        try {
            throw new NotAllowedException("returnBook in Shelved");
        } catch (NotAllowedException e) {
            System.out.println(e.toString());
        }
    }

    public String toString(){
        return "Shelved";
    }
}

class Returned implements LBState {

    //MARK: Returned Singleton
    private static Returned instance = null;
    private Returned() {
        System.out.println("Returned Instance Created");
    }
    public static Returned getInst() {
        if(instance == null)
            instance = new Returned();
        return instance;
    }

    
    public void shelf(LibraryBook book) {
        System.out.println("Leaving State Returned for State Shelved");
        book.setState(Shelved.getInst());
    }

    
    public void borrow(LibraryBook book) {
        try {
            throw new NotAllowedException("borrow in Returned");
        } catch (NotAllowedException e) {
            System.out.println(e.toString());
        }
    }

    
    public void extend(LibraryBook book) {
        try {
            throw new NotAllowedException("extend in Returned");
        } catch (NotAllowedException e) {
            System.out.println(e.toString());
        }
    }

    
    public void returnBook(LibraryBook book) {
        try {
            throw new NotAllowedException("shelf in Shelved");
        } catch (NotAllowedException e) {
            System.out.println(e.toString());
        }
    }

    public String toString(){
        return "Returned";
    }
}