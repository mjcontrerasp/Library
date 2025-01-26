import java.util.Random;

public class User {
    private String name;
    private String password;
    private Credentials credential;
    private int borrowingBooks;
    private int borrowedBooks;
    private Random random;

    /*
     * Constructor for the User class
     */
    public User(String name, String password, int borrowingBooks, int borrowedBooks, Credentials credential) {
        this.name = name;
        this.password = password;
        this.borrowingBooks = borrowingBooks;
        this.borrowedBooks = borrowedBooks;
        this.credential = credential;
        this.random = new Random();
    }
    /*
     * Constructor for the User class
     */
    public User() {
        this.name = "";
        this.password = "";
        this.borrowingBooks = 0;
        this.borrowedBooks = 0;
        this.credential = Credentials.Basic;
        this.random = new Random();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
    public String getPassword() {
        return password;
    }

    public Credentials getCredential() {
        return credential;
    }

    public int getBorrowingBooks() {
        return borrowingBooks;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword() {
        this.password = "";
        for (int i = 0; i < 4; i++) {
            this.password += String.valueOf(random.nextInt(10));
        }
    }

    public void setCredential(Credentials credential) {
        this.credential = credential;
    }

    public void setBorrowingBooks(int borrowingBooks) {
        this.borrowingBooks = borrowingBooks;
    }

    public void setBorrowedBooks(int borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public boolean isAdmin() {
        return this.credential == Credentials.Admin;
    }
}
