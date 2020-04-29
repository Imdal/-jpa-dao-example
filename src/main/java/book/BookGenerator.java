package book;

//import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import book.model.Book;

import java.util.Locale;

public class BookGenerator {
    private static Faker faker = new Faker(new Locale("en"));

    public static Book createBook() {
        Book book = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.values()))
                .publisher(faker.book().publisher())
                .publicationDate(faker.date())
                .pages(faker.number().numberBetween(1,500))
                .available(faker.bool());
        return book;
    }
}



