
public class User {
    private String name;
    private String password;
    private Credentials credential;
    private int borrowingBooks;
    private int borrowedBooks;
    private static User[] users;
    private static final int maxUser = 50;
    private static int contUser = 0;

    /*
     * Constructor for the User class
     */
    public User() {
        this.name = "";
        this.password = "";
        this.borrowingBooks = 0;
        this.borrowedBooks = 0;
        this.credential = Credentials.Basic;
        this.users = new User[maxUser];
    }

    /*
     * Constructor for the User class
     */
    public User(String name, String password, Credentials credential) {
        this();
        this.name = name;
        this.password = password;
        this.credential = credential;
    }

    public static void fullUser(String name, String password, Credentials credential) {
        if (contUser < maxUser) {
            users[contUser] = new User(name, password, credential);
            contUser++;
        }
    }

    public String getName() {
        return name;
    }

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

    public void setPassword(String password) {
        this.password = password;
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

    public static User[] getUsers() {
        return users;
    }

    public static int getContUsers() {
        return contUser;
    }
}
