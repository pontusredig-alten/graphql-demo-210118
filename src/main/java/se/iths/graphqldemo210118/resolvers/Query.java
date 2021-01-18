package se.iths.graphqldemo210118.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import se.iths.graphqldemo210118.model.Author;
import se.iths.graphqldemo210118.model.Book;
import se.iths.graphqldemo210118.repository.AuthorRepository;
import se.iths.graphqldemo210118.repository.BookRepository;

import java.util.Optional;

public class Query implements GraphQLQueryResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }

    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }



}
