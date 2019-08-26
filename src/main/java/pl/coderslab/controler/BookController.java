package pl.coderslab.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Book;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @GetMapping("/")
    public List<Book> getBooks() {
        return bookDao.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return bookDao.findById(id);
    }

    @PostMapping("/")
    public Book createBook(@RequestBody Book book) {
        return bookDao.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book editBook(@RequestBody Book book, @PathVariable long id) {
        book.setId(id);
        return bookDao.update(book);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookDao.delete(bookDao.findById(id));
    }

}

