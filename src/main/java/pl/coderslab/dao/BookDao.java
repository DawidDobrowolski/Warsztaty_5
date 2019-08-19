package pl.coderslab.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;
    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

}
