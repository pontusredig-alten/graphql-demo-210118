package se.iths.graphqldemo210118.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import se.iths.graphqldemo210118.model.Author;
import se.iths.graphqldemo210118.model.Book;
import se.iths.graphqldemo210118.repository.AuthorRepository;

import java.util.Optional;

public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId());
    }


}
