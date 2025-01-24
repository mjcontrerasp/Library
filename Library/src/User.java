public class User {
    String name;
    String password;
    Credentials credential;
    int borrowingBooks;
    int borrowedBooks;

    /**
     * 
     * @param name
     * @param password
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * getters
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
