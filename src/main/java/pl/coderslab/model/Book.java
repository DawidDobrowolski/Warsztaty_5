package pl.coderslab.model;

public class Book {

    private long id;
    private static long nextID = 1;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;


    public Book(String isbn, String title, String author, String publisher, String type) {
        this.id = nextID;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.type = type;
        nextID++;
    }

    public Book() {
        this.id = nextID;
        nextID++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    private long highestId() {
//        MemoryBookService memoryBookService = new MemoryBookService();
//        return memoryBookService.getList().stream()
//                .sorted((b1, b2) -> Long.compare(b1.id, b2.id))
//                .findFirst().get().getId();
//
//    }


}
