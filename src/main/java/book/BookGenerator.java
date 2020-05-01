package book;

import com.github.javafaker.Faker;
import com.github.javafaker.DateAndTime;
import book.model.Book;
import java.time.ZoneId;
import guice.PersistenceModule;

import java.util.Locale;

public class BookGenerator {
    private static Faker faker = new Faker(new Locale("en"));

    private static java.util.Date date=faker.date().birthday();
    private static java.time.LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    public static Book createBook() {
        Book book = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.values()))
                .publisher(faker.book().publisher())
                .publicationDate(localDate)
                .pages(faker.number().numberBetween(1,500))
                .available(faker.bool().bool())
                .build();
        return book;
    }
}



