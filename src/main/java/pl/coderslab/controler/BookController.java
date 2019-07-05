package pl.coderslab.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MemoryBookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book("9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("/")
    public List<Book> getBooks() {
        return memoryBookService.getList();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return memoryBookService.getBook(id);
    }

    @PostMapping("/")
    public void createBook(@RequestBody Book book) {
        memoryBookService.createBook(book);
    }

    @PutMapping("/{id}")
    public void editBook(@RequestBody Book book, @PathVariable long id) {
        book.setId(id);
        memoryBookService.editBook(book);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        memoryBookService.deleteBook(id);
    }

}

