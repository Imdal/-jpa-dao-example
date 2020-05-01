package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;
import static book.BookGenerator.createBook;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookGenerator bookGenerator = injector.getInstance(BookGenerator.class);
        for (int i = 0; i < 1000; i++) {
            Book book = createBook();
            System.out.println(book);
        }
//        bookGenerator.findAll()
//                .stream()
//                .forEach(System.out::println);
    }

}
