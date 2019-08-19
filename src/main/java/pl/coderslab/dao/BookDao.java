package pl.coderslab.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;


    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        return entityManager.createQuery(
                "SELECT b FROM Book b").getResultList();
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }


    public void delete(Book entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }

}
