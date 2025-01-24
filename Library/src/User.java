import java.util.Random;

public class User {
    private String name;
    private String password;
    private Credentials credentials;
    private int borrowingBooks;
    private int borrowedBooks;
    private static Random random = new Random();
    public User(){
        name = "Default";
        password = "0000";
        credentials = Credentials.Basic;
        borrowingBooks = 0;
        borrowedBooks = 0;
    }

    //GETTERS
    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public Credentials getCredentials(){
        return credentials;
    }

    public int getBorrowingBooks(){
        return borrowingBooks;
    }

    public int getBorrowedBooks(){
        return borrowedBooks;
    }

    //SETTERS
    public void setName(String name){
        this.name = name;
    }
    //borra contraseña y genera contraseña nueva random de 4 cifras del 0 al 9
    public void setPassword(){
        this.password = "";
        for (int i = 0; i < 4; i++) {
            this.password += random.nextInt(0,9);
        }
    }

    public void setCredentials(Credentials credentials){
        this.credentials = credentials;
    }

    public void setBorrowingBooks(int borrowingBooks){
        this.borrowingBooks = borrowingBooks;
    }

    public void setBorrowedBooks(int borrowedBooks){
        this.borrowedBooks = borrowedBooks;
    }
}

