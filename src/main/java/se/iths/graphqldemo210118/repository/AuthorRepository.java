package se.iths.graphqldemo210118.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.graphqldemo210118.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
