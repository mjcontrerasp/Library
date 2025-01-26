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
     * Method to add a new user
     * first menu option
     */
    private void menuLogin() {
        while (true) {
            System.out.println(
                "*****************************\n" +
                "*       MENU PRINCIPAL      *\n" +
                "*****************************\n" +
                "1. Iniciar sesión\n" +
                "2. Salir\n" +
                "*****************************"
            );
            System.out.print("Elige una opción: ");
            int choice = Integer.parseInt(sc.nextLine());
    
            switch (choice) {
                case 1:
                    System.out.print("Nombre de usuario: ");
                    String loginName = sc.nextLine();
                    System.out.print("Contraseña: ");
                    String loginPassword = sc.nextLine();
                    if (login(loginName, loginPassword)) {
                        User user = null;
                        for (int i = 0; i < numUsers; i++) {
                            if (users[i].getName().equals(loginName)) {
                                user = users[i];
                                break;
                            }
                        }
                        if (user != null) {
                            menuLibrary(user);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
                    break;
            }
        }
    }
    

    /**
     * Method to show the library menu
     * 
     * @param user
     */
    private void menuLibrary(User user) {
        while (true) {
            System.out.println("*****************************");
            System.out.println("*       MENU DE LIBRERIA    *");
            System.out.println("*****************************");
            if (user.getCredential() == Credentials.Admin) {
                System.out.println(
                "1. Agregar libro\n" +
                "2. Eliminar libro\n" +
                "3. Registrar usuario\n" +
                "4. Consultar usuarios\n" +
                "5. Mostrar libros prestados\n" +
                "6. Mostrar todos los libros\n" +
                "7. Buscar libros\n" +
                "8. Mostrar estadísticas\n" +
                "9. Salir"
            );
            } else {
                System.out.println(
                "1. Realizar préstamo\n" +
                "2. Devolver libro\n" +
                "3. Mostrar todos los libros\n" +
                "4. Buscar libros\n" +
                "5. Salir"
            );
            }
            System.out.print("Elige una opción: ");
            int choice = Integer.parseInt(sc.nextLine());
        
            if (user.getCredential() == Credentials.Admin) {
                 switch (choice) {
                 case 1->
                 case 2->
                 case 3->
                 case 4->
                 case 5->
                 case 6->
                 case 7->
                 case 8->
                 case 9-> break;
                 default ->System.out.println("Opción no válida.");
            } else {
                 switch (choice) {
                 case 1->
                 case 2->
                 case 3->
                 case 4->
                 case 5-> break;
                 default -> System.out.println("Opción no válida.");
                }
            }
                 
            }
        }
    }
}
