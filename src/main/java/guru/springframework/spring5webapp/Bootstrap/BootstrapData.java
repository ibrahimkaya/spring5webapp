package guru.springframework.spring5webapp.Bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorsReporsitory;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorsReporsitory authorsReporsitory;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorsReporsitory authorsReporsitory, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorsReporsitory = authorsReporsitory;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("eric", "Evans");
        Book ddd = new Book("domain driven desing","123");

        Author rod = new Author("rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "213123");

        Publisher ibrahim = new Publisher("ibrahim","cihannuma","istanbul","besiktas","123123");
        publisherRepository.save(ibrahim);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(ibrahim);
        ibrahim.getBooks().add(ddd);

        authorsReporsitory.save(eric);
        bookRepository.save(ddd);





        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(ibrahim);
        ibrahim.getBooks().add(noEJB);

        authorsReporsitory.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(ibrahim);

        System.out.println("Started in bootstrap");
        System.out.println("number of books: "+ bookRepository.count());

        System.out.println("Number of Publishers: "+ publisherRepository.count());

        System.out.println("publisher number of book: " + ibrahim.getBooks().size());
    }
}
