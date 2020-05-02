package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BookGenerator {

    private static Faker faker = new Faker(new Locale("en"));

    public static Book createRandomBook() {
        Book book = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(faker.date().past(100, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .pages(faker.number().numberBetween(10,10000))
                .available(faker.bool().bool())
                .build();
        return book;
    }
}
