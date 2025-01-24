import java.util.Random;
public class User {
   private String name;
   private String password;
   private Credentials credential;
   private int borrowingBooks;
   private int borrowedBooks;

    public User(String name, String password, int borrowingBooks, int borrowedBooks) {
        this.name = name;
        this.password = password;
        this.borrowingBooks = 0;
        this.borrowedBooks = 0;
    }
    public User(){
        this.name = "";
        this.password = "";
        this.borrowingBooks = 0;
        this.borrowedBooks = 0;
    }

    public String getName(){
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Credentials getCredentials() {
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

    public void setPassword() { // borra contraseña y genera contraseña nueva random de 4 cifras del 0 al 9
        this.password = "";
        for (int i = 0; i < 4; i++) {
            this.password += String.valueOf(random.nextInt(10));
        }
    }

    public void setCredentials(Credentials credential) {
        this.credential = credential;
    }

    public void setBorrowingBooks(int borrowingBooks) {
        this.borrowingBooks = borrowingBooks;
    }

    public void setBorrowedBooks(int borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
