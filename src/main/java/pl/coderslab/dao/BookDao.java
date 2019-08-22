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


    public Book saveBook(Book entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Book findById(long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    public List<Book> findAll() {
        return entityManager.createQuery(
                "SELECT b FROM Book b").getResultList();
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }


    public void delete(Book entity) {
        if (entity != null) {
            entityManager.remove(entityManager.contains(entity) ?
                    entity : entityManager.merge(entity));
        }
    }


}
