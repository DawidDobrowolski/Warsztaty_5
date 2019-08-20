package pl.coderslab.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @GetMapping("/")
    public List<Author> getAuthors() {
        return authorDao.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable long id) {
        return authorDao.findById(id);
    }

    @PostMapping("/")
    public void createAuthor(@RequestBody Author author) {
        authorDao.saveAuthor(author);
    }

    @PutMapping("/{id}")
    public void editAuthor(@RequestBody Author author, @PathVariable long id) {
        author.setId(id);
        authorDao.update(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable long id) {
        authorDao.delete(authorDao.findById(id));
    }
}
