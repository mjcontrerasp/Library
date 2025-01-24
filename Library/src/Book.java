public class Book {
    private String title, author;
    private Category category;
    private Status status;

    public Book() {
        title = "Default";
        author = "Default";
        category = Category.Default;
        status = Status.Available;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public Status getStatus() {
        return status;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
