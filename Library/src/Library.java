public class Library {
    public int numUsers = 0;
    public int maxUsers = 50;
    public User [] users = new User [maxUsers];
    public static void main(String[] args) throws Exception {
        Credentials currentUser;
        int maxBooks = 60;
        Book [] books = new Book [maxBooks];
        int numBooks = 0;

    }
    public Boolean login(String loginName, String loginPassword){
        for (int i = 0; i < numUsers; i++) {
            if (users[i].getName().equals(loginName)) {
                if(users[i].getPassword().equals(loginPassword)){
                    return true;
                }else{
                    System.out.println("Wrong password");
                }
            }
        }
        System.out.println("Wrong user name");
        return false;
    }

}
