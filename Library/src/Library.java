import java.util.Scanner;

public class Library {
    public static final Scanner sc = new Scanner(System.in);

    public static int numUsers = 0;
    public static int maxUsers = 50;
    public static User[] users = new User[maxUsers];

    /**
     * Main method
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Credentials currentUser;
        int maxBooks = 60;
        Book[] books = new Book[maxBooks];
        int numBooks = 0;

        menuLogin();

        sc.close();
    }

    /**
     * Method to comproved credenthial to login
     * 
     * @param name
     * @param password
     * @param email
     * @param age
     * @param address
     * @param phone
     * @return
     */
    public static Boolean login(String loginName, String loginPassword) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].getName().equals(loginName)) {
                if (users[i].getPassword().equals(loginPassword)) {
                    return true;
                } else {
                    System.out.println("Wrong password");
                }
            }
        }
        System.out.println("Wrong user name");
        return false;
    }

    /*
     * Method to show the login menu
     */
    public static void menuLogin() {
        while (true) {
            System.out.println();
            System.out.println("*****************************");
            System.out.println("*                           *");
            System.out.println("*   BIBLIOTECA DEL PUEBLO   *");
            System.out.println("*                           *");
            System.out.println("*****************************");
            System.out.println("* 1. Iniciar sesión         *");
            System.out.println("* 0. Salir                  *");
            System.out.println("*****************************");
            System.out.print("Elige una opción: ");
            int choice = sc.nextInt();
            System.out.println();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Nombre de usuario: ");
                String loginName = sc.nextLine();
                System.out.print("Contraseña: ");
                String loginPassword = sc.nextLine();
                if (login(loginName, loginPassword)) {
                    System.out.println("Inicio de sesión exitoso.");
                    break;
                }
            } else if (choice == 0) {
                System.out.println("Saliendo del sistema.");
                break;
            } else {
                System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
        }
    }

}
