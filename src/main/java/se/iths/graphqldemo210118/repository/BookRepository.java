package se.iths.graphqldemo210118.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.graphqldemo210118.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
