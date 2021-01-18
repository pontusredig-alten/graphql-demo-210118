package se.iths.graphqldemo210118;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.graphqldemo210118.model.Author;
import se.iths.graphqldemo210118.model.Book;
import se.iths.graphqldemo210118.repository.AuthorRepository;
import se.iths.graphqldemo210118.repository.BookRepository;
import se.iths.graphqldemo210118.resolvers.BookResolver;
import se.iths.graphqldemo210118.resolvers.Mutation;
import se.iths.graphqldemo210118.resolvers.Query;

@SpringBootApplication
public class GraphqlDemo210118Application {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemo210118Application.class, args);
	}

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Query(authorRepository, bookRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(authorRepository, bookRepository);
	}

	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
		return (args) -> {
			Author author1 = new Author("Karin", "Boye");
			authorRepository.save(author1);
			Author author2 = new Author("Harry", "Martinsson");
			authorRepository.save(author2);

			Book book1 = new Book("Kallocain", "71472137", 230, author1);
			bookRepository.save(book1);
			Book book2 = new Book("Aniara", "7263743", 175, author2);
			bookRepository.save(book2);

		};
	}

}
