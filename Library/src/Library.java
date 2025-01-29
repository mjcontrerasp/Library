import java.util.Scanner;


public class Library {
    public static final Scanner sc = new Scanner(System.in);

    public static int contUsers = 0;
    public static int maxUsers = 50;
    public static User[] users = new User[maxUsers];
    public static int maxBooks = 60;
    public static Book[] books = new Book[maxBooks];
    public static int numBooks = 0;
    public static Book[] searchBooks = new Book[maxBooks]; // Array temporal para buscar libros
    public static int numSearchBooks = 0;
    public static int totalBorrowedBooks = 0;
    public static User maxBorrowedBooksUser;
    public static final int numBooksRanking = 1;

    /**
     * Main method
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        fullUser("admin", "1234", Credentials.Admin);
        fullUser("user1", "1234", Credentials.Basic);
        fullUser("user2", "1234", Credentials.Basic);
        menuLogin();

        books[0] = new Book("Don Quijote de la Mancha", "Miguel de Cervantes", Category.Fiction);
        books[1] = new Book("Cien años de soledad", "Gabriel García Márquez", Category.Fiction);
        books[2] = new Book("1984", "George Orwell", Category.Science);
        books[3] = new Book("Orgullo y prejuicio", "Jane Austen", Category.Fiction);
        books[4] = new Book("El gran Gatsby", "F. Scott Fitzgerald", Category.Fiction);
        books[5] = new Book("Matar a un ruiseñor", "Harper Lee", Category.Fiction);
        books[6] = new Book("Crimen y castigo", "Fiódor Dostoyevski", Category.Fiction);
        books[7] = new Book("Harry Potter y la piedra filosofal", "J.K. Rowling", Category.Fiction);
        books[8] = new Book("El Hobbit", "J.R.R. Tolkien", Category.Fiction);
        books[9] = new Book("En busca del tiempo perdido", "Marcel Proust", Category.Fiction);

        sc.close();
    }
    /**
     * Method to compress the array of users
     * 
     * @param name
     * @param password
     * @param credential
     */
    public static void fullUser(String name, String password, Credentials credential) {
        if (contUsers < maxUsers) {
            users[contUsers] = new User(name, password, credential);
            contUsers++;
        }
    }

    /**
     * Method to show the user information
     * 
     * @param user
     */
    public static void addNewUser() {
        boolean choice = true;
        String name = "";
        while (choice) {
            System.out.println("Nombre de usuario: ");
            name = sc.nextLine();
            if (!notRepeatName(name)) {
                System.out.println("Nombre de usuario ya en uso, por favor, elija un nombre de usuario nuevo");
            } else {
                choice = false;
            }
        }
        System.out.println("Contraseña: ");
        String password = sc.nextLine();

        Credentials userCredential = null;
        while (userCredential == null) {
            System.out.print("Tipo de usuario (1. Administrador, 2. Básico): ");
            int userType = Integer.parseInt(sc.nextLine());
            switch (userType) {
                case 1 -> userCredential = Credentials.Admin;
                case 2 -> userCredential = Credentials.Basic;
                default -> System.out.println("Opción no válida. Por favor, elija 1 o 2.");
            }
        }
        fullUser(name, password, userCredential); 
        System.out.println("Usuario registrado correctamente.");

    }

    /**
     * Method to show repated name
     * 
     * @param user
     */
    public static boolean notRepeatName(String userName) {
        for (int i = 0; i < contUsers; i++) {
            if (users[i].getName().equals(userName)) {
                return false;
            }
        }
        return true;
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
        for (int i = 0; i < contUsers; i++) {
            if (users[i].getName().equals(loginName)) {
                if (users[i].getPassword().equals(loginPassword)) {
                    return true;
                } else {
                    System.out.println("Contraseña incorrecta");
                }
            }
        }
        System.out.println("Nombre de usuario incorrecto");
        return false;
    }

    /*
     * first menu option
     */
    public static void menuLogin() {
        while (true) {
            System.out.println(
                    "*****************************\n" +
                            "*       MENU PRINCIPAL      *\n" +
                            "*****************************\n" +
                            "1. Iniciar sesión\n" +
                            "2. Salir\n" +
                            "*****************************");
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
                        for (int i = 0; i < contUsers; i++) {
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
                    break;
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
    public static void menuLibrary(User user) {
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
                "6. Realizar préstamo\n" +
                "7. Devolver libro\n" +
                "8. Mostrar todos los libros\n" +
                "9. Buscar libros\n" +
                "10. Mostrar préstamos totales y actuales\n" +
                "11. Mostrar libros más prestados\n" +
                "12. Mostrar usuario con más prestamos activos\n" +
                "13. Mostrar libros para devolver\n" +
                "14. Salir"
            );
            } else {
                System.out.println(
                "1. Realizar préstamo\n" +
                "2. Devolver libro\n" +
                "3. Mostrar todos los libros\n" +
                "4. Buscar libros\n" +
                "5. Mostrar libros para devolver\n" +
                "6. Salir"
            );
            
            }
            
            System.out.print("Elige una opción: ");
            int choice = Integer.parseInt(sc.nextLine());
            
            if (user.getCredential() == Credentials.Admin) {
                 switch (choice) {
                 case 1-> addNewBook();
                 case 2-> {System.out.print("Posicion del libro a eliminar: "); int position = Integer.parseInt(sc.nextLine()); deleteBook(position); reorganiceBooks();}
                 case 3-> addNewUser();
                 case 4-> userSee();
                 case 5-> {searchBooks(); printSearchBooks();} //case 5 y case 7 son iguales con el codigo de esta forma
                 case 6-> {System.out.print("Posicion del libro que se quiere coger: "); int position = Integer.parseInt(sc.nextLine()); user.borrowBook(position);}
                 case 7-> {System.out.print("Posicion del libro que se quiere devolver: "); int position = Integer.parseInt(sc.nextLine()); user.borrowBook(position);}
                 case 8-> printBooks();
                 case 9-> {searchBooks(); printSearchBooks();
                 case 10-> showTotalAndCurrentBorrowedBooks();
                 case 11-> showBooksRanking();
                 case 12-> userInfo(maxBorrowedBooksUser());
                 case 13-> break;
                 case 14-> break;
                 default ->System.out.println("Opción no válida.");
                }
            }else {
                 switch (choice) {
                 case 1-> break;
                 case 2-> break;
                 case 3-> printBooks();
                 case 4-> {searchBooks(); printSearchBooks();}
                 case 6-> user.showBorrowingList();
                 case 5-> userInfo(user);
                 default -> System.out.println("Opción no válida.");
                }
            }
        }
    }

    /**
     * Muestra todas categorias
     * Elije una opcion
     * 
     * @return category seleccionada
     */
    public static Category menuCategory() {
        Category category = Category.Default;
        boolean flag;
        do {
            flag = false;
            System.out.println(
                    "\n1- Fiction"
                            + "\n2- NonFiction"
                            + "\n3- Educational"
                            + "\n4- Science"
                            + "\n5- Philosophy"
                            + "\n6- Business"
                            + "\n7- ChildrenBook"
                            + "\n8- Default");
            System.out.print("Elije una opcion: ");
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> category = Category.Fiction;
                case 2 -> category = Category.NonFiction;
                case 3 -> category = Category.Educational;
                case 4 -> category = Category.Science;
                case 5 -> category = Category.Philosophy;
                case 6 -> category = Category.Business;
                case 7 -> category = Category.ChildrenBook;
                case 8 -> category = Category.Default;
                default -> {
                    flag = true;
                    System.out.println("Opcion inválida, vuelve a elegir");
                }
            }
        } while (flag);
        return category;
    }

    /**
     * Muestra todos status
     * Elije una opcion
     * 
     * @return status seleccionada
     */
    public static Status menuStatus() {
        Status status = Status.Available;
        boolean flag;
        do {
            flag = false;
            System.out.println(
                    "\n1- Available"
                            + "\n2- Borrowed");
            System.out.print("Elije una opcion: ");
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> status = Status.Available;
                case 2 -> status = Status.Borrowed;
                default -> {
                    flag = true;
                    System.out.println("Opcion inválida, vuelve a elegir");
                }
            }
        } while (flag);
        return status;
    }

    /**
     * chequea espacio biblioteca
     * Escanea titulo, autor y categoria
     * crea un nuevo Book en posicion numBooks
     */
    public static void addNewBook() {
        // Comprobacion de espacio
        if (numBooks >= maxBooks) {
            System.out.println("Biblioteca llena.");
        } else {
            // Introduccion de parametros
            System.out.print("Titulo: ");
            String title = sc.nextLine();
            System.out.print("Autor");
            String author = sc.nextLine();
            Category category = menuCategory();
            // Añade libro
            books[numBooks] = new Book(title, author, category);
            System.out.println("Libro añadido a posicion " + numBooks);
            numBooks++;

        }
    }

    /*
     * shearchBooks for cathegory or status
     */
    public static void searchBooks() {
        // Borrar array temporal de busqueda de libros
        for (int i = 0; i < numBooks; i++) {
            searchBooks[i] = null;
        }
        // Resetear contador numSearchBooks
        numSearchBooks = 0;
        boolean flag;
        do {
            flag = false;
            System.out.println(
                    "\n1- Titulo"
                            + "\n2- Autor"
                            + "\n3- Categoria"
                            + "\n4- Estado");
            System.out.print("Elije una opcion: ");
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> {
                    System.out.print("Tiulo: ");
                    String title = sc.nextLine();
                    for (int i = 0; i < numBooks; i++) {
                        if (books[i].getTitle().equals(title)) {
                            searchBooks[i] = books[i];
                            numSearchBooks++;
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Autor: ");
                    String author = sc.nextLine();
                    for (int i = 0; i < numBooks; i++) {
                        if (books[i].getAuthor().equals(author)) {
                            searchBooks[i] = books[i];
                            numSearchBooks++;
                        }
                    }
                }
                case 3 -> {
                    Category category = menuCategory();
                    for (int i = 0; i < numBooks; i++) {
                        if (books[i].getCategory() == category) {
                            searchBooks[i] = books[i];
                            numSearchBooks++;
                        }
                    }
                }
                case 4 -> {
                    Status status = menuStatus();
                    for (int i = 0; i < numBooks; i++) {
                        if (books[i].getStatus() == status) {
                            searchBooks[i] = books[i];
                            numSearchBooks++;
                        }
                    }
                }
                default -> {
                    flag = true;
                    System.out.println("Opcion inválida, vuelve a elegir");
                }
            }
            System.out.println("Se han encontrado " + numSearchBooks + " libros.");
            System.out.println("Se han encontrado " + numSearchBooks + " libros.");
        } while (flag);
    }

    // Muestra todos los libros del array searchBooks
    public static void printSearchBooks() {
        for (int i = 0; i < numBooks; i++) {
            if (searchBooks[i] != null) {
                System.out.println("\nLibro: " + i
                        + "\nTitulo: " + searchBooks[i].getTitle()
                        + "\nAutor:" + searchBooks[i].getTitle()
                        + "\nCategoria:" + searchBooks[i].getCategory()
                        + "\nEstado:" + searchBooks[i].getStatus());
            }
        }
    }

    // Muestra 1 libro del array books
    public static void printBook(int position) {
            System.out.println("\nLibro: " + position
                    + "\nTitulo: " + books[position].getTitle()
                    + "\nAutor:" + books[position].getTitle()
                    + "\nCategoria:" + books[position].getCategory()
                    + "\nEstado:" + books[position].getStatus());
    }

    // Muestra todos los libros del array books
    public static void printBooks() {
        for (int i = 0; i < numBooks; i++) {
            System.out.println("\nLibro: " + i
                    + "\nTitulo: " + books[i].getTitle()
                    + "\nAutor:" + books[i].getTitle()
                    + "\nCategoria:" + books[i].getCategory()
                    + "\nEstado:" + books[i].getStatus());
        }
    }

    // Elimina un libro
    public static void deleteBook(int position) {
        books[position] = null;
        numBooks--;
        System.out.println("\nLibro " + position + " eliminado.");
    }

    // Reorganiza books[] para que no haya huecos
    public static void reorganiceBooks() {
        for (int i = 0; i < maxBooks; i++) {
            if (books[i] == null) {
                for (int j = i; j < maxBooks - 1; j++) {
                    books[i] = books[i + 1];
                }
                books[maxBooks] = null;
            }
        }
        System.out.println("Librería reorganizada.");
    }

    public static void showTotalAndCurrentBorrowedBooks() {
        System.out.println("Préstamos totales: " + totalBorrowedBooks);
        int totalCurrentBorrowingBooks = 0;
        for (int i = 0; i < numUsers; i++) {
            totalCurrentBorrowingBooks += users[i].getBorrowingBooks();
        }
        System.out.println("Préstamos actuales: " + totalCurrentBorrowingBooks);
    }

    public static User maxBorrowedBooksUser() {
        maxBorrowedBooksUser = null;
        for (int i = 0; i < numUsers; i++) {
            if (maxBorrowedBooksUser.getBorrowedBooks() < users[i].getBorrowedBooks()) {
                maxBorrowedBooksUser = users[i];
            }
        }
        return maxBorrowedBooksUser;
    }

    //FALTAAAAA. De momento solo muestro 1 libro, quiero mostrar 3.
    public static void showBooksRanking() {
        int position1=0; //position2, position3;
        int maxBorrowedTimes = 0;
        if (numBooks < numBooksRanking) {
            System.out.println("\nLibros insuficientes para hacer ranking,"
                    + "solo hay " + numBooks + ", se necesitan al menos " + numBooksRanking);
        } else {
            for (int i = 0; i < numBooks; i++) {
                if (maxBorrowedTimes <= books[i].getBorrowedTimes()) {
                    position1 = i;
                }
            }
            printBook(position1);
        }
        
    }
    /*
     * Muestra la informacion del usuario
     */
    public static void userInfo(User user) {
        System.out.println("Información del usuario:");
        System.out.println("Nombre: " + user.getName());
        System.out.println("Contraseña: " + user.getPassword());
        System.out.println("Credenciales: " + user.getCredential());
        System.out.println("Libros en préstamo: " + user.getBorrowingBooks());
        System.out.println("Libros prestados: " + user.getBorrowedBooks());
    }

    /*
     * Muestra la informacion de todos los usuarios
     */
    public static void userSee(){
        for (int i = 0; i < contUsers; i++) {
            User user = users[i];
            if (user != null) {
                System.out.println("Nombre: " + user.getName());
                System.out.println("Contraseña: " + user.getPassword());
                System.out.println("Credenciales: " + user.getCredential());
                System.out.println("Libros en préstamo: " + user.getBorrowingBooks());
                System.out.println("Libros prestados: " + user.getBorrowedBooks());
                System.out.println("------------------------------");
            }
        }

}
}
