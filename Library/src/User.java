
public class User {
    private String name;
    private String password;
    private Credentials credential;
    private int borrowingBooks;
    private int borrowedBooks;
    private Book[] borrowingList;

    /*
     * Constructor for the User class
     */
    public User() {
        this.name = "";
        this.password = "";
        this.borrowingBooks = 0;
        this.borrowedBooks = 0;
        this.credential = Credentials.Basic;
        this.borrowingList = null;
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

    public Book[] getBorrowingList() {
        return borrowingList;
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

    public boolean isAdmin() {
        return this.credential == Credentials.Admin;
    }

    // BorrowedBooks ++
    public void addBorrowedBooks(int borrowedBooks) {
        this.borrowedBooks += borrowedBooks;
    }

    // Methods
    public void borrowBook(int bookPosition) {
        Library.books[bookPosition].setStatus(Status.Borrowed);
        Library.books[bookPosition].addBorrowedTimes(1);
        Library.totalBorrowedBooks++;
        borrowingList[bookPosition] = Library.books[bookPosition];
        addBorrowedBooks(1);
        setBorrowingBooks(1);
        System.out.println("\nLibro " + bookPosition + " entregado.");
    }

    public void returnBook(int bookPosition) {
        borrowingList[bookPosition] = null;
        Library.books[bookPosition].setStatus(Status.Available);
        setBorrowingBooks(-1);
        System.out.println("\nLibro " + bookPosition + " devuelto.");
    }

    public void showBorrowingList() {
        for (int i = 0; i < Library.numBooks; i++) {
            if (borrowingList[i] != null) {
                System.out.println("\nLibro: " + i
                        + "\nTitulo: " + borrowingList[i].getTitle()
                        + "\nAutor:" + borrowingList[i].getTitle()
                        + "\nCategoria:" + borrowingList[i].getCategory()
                        + "\nEstado:" + borrowingList[i].getStatus());
            }
        }
    }
<<<<<<< HEAD

    // print user info
    // FALTAAAAAA
=======
>>>>>>> origin/DEVELOP
}
