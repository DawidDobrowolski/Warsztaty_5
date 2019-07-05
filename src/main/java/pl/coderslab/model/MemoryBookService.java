package pl.coderslab.model;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoryBookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book( "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book( "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book( "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book getBook(long bookId) {
        List<Book> newList = list.stream()
                .filter(b -> b.getId() == bookId)
                .collect(Collectors.toList());

        return newList.get(0);
    }

    public void createBook(Book book) {
        list.add(book);
    }

    public void editBook(Book book) {
        list = list.stream()
                .filter(b -> b.getId() != book.getId())
                .collect(Collectors.toList());
        list.add(book);
    }

    public void deleteBook(long bookId) {
        list = list.stream()
                .filter(b -> b.getId() != bookId)
                .collect(Collectors.toList());
    }
}
