import java.util.Scanner;

public class Library {
    public static final Scanner sc = new Scanner(System.in);

    public static int numUsers = 0;
    public static int maxUsers = 50;
    public static User[] users = new User[maxUsers];
    public static int maxBooks = 60;
    public static Book[] books = new Book[maxBooks];
    public static int numBooks = 0;
    public static Book[] searchBooks = new Book[maxBooks]; // Array temporal para buscar libros
    public static int numSearchBooks = 0;

    /**
     * Main method
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Credentials currentUser;

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
                 case 1-> addNewBook();
                 case 2-> {System.out.print("Posicion del libro a eliminar: "); int position = Integer.parseInt(sc.nextLine()); deleteBook(position); reorganiceBooks();}
                 case 3->
                 case 4->
                 case 5-> {searchBooks(); printSearchBooks();} //case 5 y case 7 son iguales con el codigo de esta forma
                 case 6-> printBooks();
                 case 7-> {searchBooks(); printSearchBooks();}
                 case 8->
                 case 9-> break;
                 default ->System.out.println("Opción no válida.");
                }
            }else {
                 switch (choice) {
                 case 1->
                 case 2->
                 case 3-> printBooks();
                 case 4-> {searchBooks(); printSearchBooks();}
                 case 5-> break;
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

    public static void searchBooks() {
        // Borrar array temporal de busqueda de libros
        for (int i = 0; i < numBooks; i++) {
            searchBooks[i] = null;
        }
        //Resetear contador numSearchBooks
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
            System.out.println("Se han encontrado "+numSearchBooks+" libros.");
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
    }

}
